package team.dahaeng.android.domain.community.repository

import team.dahaeng.android.domain.community.model.tmap.FullTextGeocodingResult
import team.dahaeng.android.domain.community.model.tmap.ReverseGeocodingResult

interface TMapRepository {
    suspend fun getFullTextGeocodingData(address : String) : FullTextGeocodingResult
    suspend fun getReverseGeocodingData(lat : Long, lon : Long) : ReverseGeocodingResult
}