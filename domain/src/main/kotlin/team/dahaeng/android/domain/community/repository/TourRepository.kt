package team.dahaeng.android.domain.community.repository

import team.dahaeng.android.domain.community.model.tour.areabasedlist.AreaBasedListResponse
import team.dahaeng.android.domain.community.model.tour.areacode.AreaCodeResponse
import team.dahaeng.android.domain.community.model.tour.catergorycode.CategoryCodeResponse
import team.dahaeng.android.domain.community.model.tour.searchkeyword.SearchKeywordResponse
import team.dahaeng.android.domain.community.model.tour.locationbasedlist.LocationBasedListResponse

interface TourRepository {
    suspend fun importAreaCode(): AreaCodeResponse
    suspend fun importCategoryCode(): CategoryCodeResponse
    suspend fun importAreaBasedList(): AreaBasedListResponse
    suspend fun importLocationBasedList(mapX: Double, mapY: Double): LocationBasedListResponse
    suspend fun importSearchKeyword(keyword: String): SearchKeywordResponse
}