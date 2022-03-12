package team.dahaeng.android.data.tour

import team.dahaeng.android.data.api.TourApi
import team.dahaeng.android.domain.community.model.tour.areabasedlist.AreaBasedListResponse
import team.dahaeng.android.domain.community.model.tour.areacode.AreaCodeResponse
import team.dahaeng.android.domain.community.model.tour.catergorycode.CategoryCodeResponse
import team.dahaeng.android.domain.community.model.tour.searchkeyword.SearchKeywordResponse
import team.dahaeng.android.domain.community.model.tour.locationbasedlist.LocationBasedListResponse
import team.dahaeng.android.domain.community.repository.TourRepository

class TourRepositoryImpl(private val api: TourApi) : TourRepository {


    override suspend fun importAreaCode(): AreaCodeResponse {
        val result = api.getAreaCode()
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }

    override suspend fun importCategoryCode(): CategoryCodeResponse {
        val result = api.getCategoryCode()
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }

    override suspend fun importAreaBasedList(): AreaBasedListResponse {
        val result = api.getAreaBasedList()
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }

    override suspend fun importLocationBasedList(mapX : Double, mapY : Double): LocationBasedListResponse {
        val result = api.getLocationBasedList(
            mapX = mapX,
            mapY = mapY,
            radius = 1000
        )
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }

    override suspend fun importSearchKeyword(keyword : String): SearchKeywordResponse {
        val result = api.getSearchKeyword(keyword = keyword)
        return if (result.isSuccessful && result.body() != null) {
            result.body()!!
        } else {
            throw Exception(result.errorBody().use { it.toString() })
        }
    }
}