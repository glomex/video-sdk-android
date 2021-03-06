package com.glomex.contentsdk.data

import com.google.gson.annotations.SerializedName

/**
 * Content record.
 * ```
 *  {
 *      "clip_id": "v-bkjbsi6sv3m9",
 *      "error_code": "contentGeoblocked",
 *      "tracking": {
 *          "adBegin": [],
 *          "contentBegin": [],
 *          "contentError": [
 *              {
 *                  "method": "get",
 *                  "payload": {},
 *                  "url": "https://player-feedback-mds.glomex.com/pf/?clientName=sdk&product=MES&eventName=Content%20Error&contentId=v-bkjbsi6sv3m9&geoLocation=ua&publisherId=t-b7gsdgxwu79t&playerId=teaser-1mcujg5frj4oa0fv2&salesHouseId=unknown&href=https%3A%2F%2Fwww.tz.de%2F&technologyType=ios&uniqueTrackId=eb8c18b7-8cf6-4836-b8b1-222da35cfea4"
 *              }
 *          ]
 *      }
 *  }
 * ```
 */
internal data class Video(
        @SerializedName("clip_id") val method: String,
        @SerializedName("source") val source: Source,
        @SerializedName("tracking") val tracking: Map<String, List<Tracking>>
)


