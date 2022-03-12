package team.dahaeng.android.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import team.dahaeng.android.domain.community.model.tour.areabasedlist.AreaBasedListResponse
import team.dahaeng.android.domain.community.model.tour.areacode.AreaCodeResponse
import team.dahaeng.android.domain.community.model.tour.catergorycode.CategoryCodeResponse
import team.dahaeng.android.domain.community.model.tour.searchkeyword.SearchKeywordResponse
import team.dahaeng.android.domain.community.model.tour.locationbasedlist.LocationBasedListResponse
import java.net.URLDecoder

interface TourApi {

    @GET("areaCode")
    suspend fun getAreaCode(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String = "AND",
        @Query("MobileApp") MobileApp : String = "Dahaeng",
        @Query("_type") type : String = "json"
    ) : Response<AreaCodeResponse>

    @GET("categoryCode")
    suspend fun getCategoryCode(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String = "AND",
        @Query("MobileApp") MobileApp : String = "Dahaeng",
        @Query("_type") type : String = "json"
    ): Response<CategoryCodeResponse>

    @GET("areaBasedList")
    suspend fun getAreaBasedList(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String = "AND",
        @Query("MobileApp") MobileApp : String = "Dahaeng",
        @Query("_type") type : String = "json"
    ) : Response<AreaBasedListResponse>

    @GET("locationBasedList")
    suspend fun getLocationBasedList(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String = "AND",
        @Query("MobileApp") MobileApp : String = "Dahaeng",
        @Query("mapX") mapX : Double,
        @Query("mapY") mapY : Double,
        @Query("radius") radius : Int,
        @Query("_type") type : String = "json"
    ) : Response<LocationBasedListResponse>

    @GET("searchKeyword")
    suspend fun getSearchKeyword(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String = "AND",
        @Query("MobileApp") MobileApp : String = "Dahaeng",
        @Query("keyword") keyword : String,
        @Query("_type") type : String = "json"
    ) : Response<SearchKeywordResponse>
}