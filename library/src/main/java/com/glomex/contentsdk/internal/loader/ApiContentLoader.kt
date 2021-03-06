package com.glomex.contentsdk.internal.loader

import com.glomex.contentsdk.ContentSdk
import com.glomex.contentsdk.data.Error
import com.glomex.contentsdk.data.Video
import com.glomex.contentsdk.error.ContentLoadingError
import com.glomex.contentsdk.error.ContentSdkError
import com.glomex.contentsdk.internal.api.GlomexApi
import com.glomex.contentsdk.internal.api.GlomexApi.VideoResponse
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/** Loads content by REST API call. */
internal class ApiContentLoader(
        private val api: GlomexApi,
        private val gson: Gson = Gson()
): ContentLoader {

    override fun load(config: ContentSdk.ContentConfig,
                      callback: (video: Video) -> Unit,
                      error: ((Throwable) -> Unit)?) {
        api.loadVideo(config.integrationId, config.contentId, config.pageUrl)
                .enqueue(object : Callback<VideoResponse> {
                    override fun onResponse(call: Call<VideoResponse>, response: Response<VideoResponse>) {
                        if (response.isSuccessful) {
                            response.body()?.let {
                                callback(it.video)
                            } ?: error?.invoke(ContentLoadingError(
                                    ContentLoadingError.PARSING_ERROR,
                                    "Failed to parse content"
                            ))
                        } else {
                            // something went wrong
                            try {
                                val errorBody = response.errorBody()?.string()
                                val message = gson.fromJson(errorBody, Error::class.java).getMessage()
                                error?.invoke(ContentLoadingError(
                                        ContentLoadingError.RESPONSE_ERROR,
                                        message
                                ))
                            } catch (ex: JsonSyntaxException) {
                                error?.invoke(ContentLoadingError(
                                        ContentLoadingError.RESPONSE_ERROR,
                                        "Content loading request failed",
                                        ex
                                ))
                            }
                        }
                    }

                    override fun onFailure(call: Call<VideoResponse>, t: Throwable) {
                        error?.invoke(ContentSdkError(
                                ContentSdkError.NETWORK_ERROR,
                                "Problems with network request",
                                t
                        ))
                    }
                })
    }

}