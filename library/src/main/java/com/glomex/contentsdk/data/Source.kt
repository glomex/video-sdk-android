package com.glomex.contentsdk.data

import android.os.Parcelable
import android.support.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Content source.
 * ```
 *  {
 *      progressive: "https://video-cdn-eu-west-1.mes.glomex.cloud/eyJhbGciOiJSUzUxMiJ9.eyJ2aWRlb0lkcyI6WyJ2LWJramJzaTZzdjNtOSJdLCJleHAiOjE1MjMwMDIxNDd9.MC0CFFbaV5_6g7b7jlmy9E10n6loM-ABAhUA6MgPxQ-WqPhL0sCJiOCWURl1BGY/58c6d9/v-bkjbsi6sv3m9/stream.mp4",
 *      hls: "https://video-cdn-eu-west-1.mes.glomex.cloud/eyJhbGciOiJSUzUxMiJ9.eyJ2aWRlb0lkcyI6WyJ2LWJramJzaTZzdjNtOSJdLCJleHAiOjE1MjMwMDIxNDd9.MC0CFFbaV5_6g7b7jlmy9E10n6loM-ABAhUA6MgPxQ-WqPhL0sCJiOCWURl1BGY/58c6d9/v-bkjbsi6sv3m9/stream.m3u8"
 *  }
 * ```
 */
@Keep
@SuppressWarnings("ParcelCreator")
@Parcelize
data class Source(
        @SerializedName("progressive") val progressive: String? = null,
        @SerializedName("hls") val hls: String? = null
): Parcelable


