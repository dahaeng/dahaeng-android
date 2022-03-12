package team.dahaeng.android.data.tmap

import team.dahaeng.android.data.api.TMapApi
import team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding.FullTextGeocodingResponse
import team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding.ReverseGeocodingResponse
import team.dahaeng.android.domain.community.repository.TMapRepository

class TMapRepositoryImpl(private val api: TMapApi) : TMapRepository {
    override suspend fun getFullTextGeocodingData(address: String): FullTextGeocodingResponse {
        val result = api.getFullTextGeocoding(fullAddr = address)
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }

    override suspend fun getReverseGeocodingData(lat: Long, lon: Long): ReverseGeocodingResponse {
        val result = api.getReverseGeocoding(
            lat = lat.toString(),
            lon = lon.toString()
        )
        return if (result.isSuccessful && result.body() != null) {
           result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }
}