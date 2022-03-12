package team.dahaeng.android.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding.FullTextGeocodingResponse
import team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding.ReverseGeocodingResponse

interface TMapApi {
    @GET("fullAddrGeo")
    suspend fun getFullTextGeocoding(
        @Query("version") version: Int = 1,
        @Query("fullAddr") fullAddr: String,
        @Query("appKey") appKey: String = "l7xx0eea7c3ad5a7444d88838dee8442c9ca"
    ): Response<FullTextGeocodingResponse>

    @GET("reversegeocoding")
    suspend fun getReverseGeocoding(
        @Query("version") version: Int = 1,
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appKey") appKey: String = "l7xx0eea7c3ad5a7444d88838dee8442c9ca"
    ): Response<ReverseGeocodingResponse>
}