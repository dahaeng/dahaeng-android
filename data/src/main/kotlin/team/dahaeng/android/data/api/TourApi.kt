package team.dahaeng.android.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URLDecoder
import java.net.URLEncoder

interface TourApi {

    /*
    @GET("tmapTotalTarItsBroDDList")

    suspend fun getTourData(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
        @Query("MobileOS") MobileOs : String,
        @Query("MobileApp") MobileApp : String,
        @Query("numOfRows") numOfRows : Int = 1,
        @Query("pageNo") pageNo : Int = 1,
        @Query("baseYm") baseYm : Int = 202106
        //@Query("keyword") keyword : String
    ) : String
    */


    @GET("searchKeyword")
    suspend fun getTourData(
        @Query("serviceKey") serviceKey: String = URLDecoder.decode("eD8gU4DZEESvcVbOH%2FwaIi58MhFWb5wHhSitrgjeYTn1TkkwqIb%2BYhuvm3mGU2uSbsTS2Kv%2BXNlDxxWUGK5E3g%3D%3D", "UTF-8"),
//        @Query("numOfRows") numOfRows : Int = 30,
//        @Query("pageNo") pageNo : Int = 5,
//        @Query("contentTypeId") contentTypeId : Int = 32,
        @Query("MobileOS") MobileOs : String,
        @Query("MobileApp") MobileApp : String,
        @Query("keyword") keyword : String = "강원 펜션"
    ) : String
}