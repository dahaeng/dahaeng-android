package team.dahaeng.android.domain.community.repository

import team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding.FullTextGeocodingResponse
import team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding.ReverseGeocodingResponse

interface TMapRepository {
    suspend fun getFullTextGeocodingData(address : String) : FullTextGeocodingResponse
    suspend fun getReverseGeocodingData(lat : Long, lon : Long) : ReverseGeocodingResponse
}