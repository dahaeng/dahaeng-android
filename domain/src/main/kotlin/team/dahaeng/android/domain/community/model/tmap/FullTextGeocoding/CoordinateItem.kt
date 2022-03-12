package team.dahaeng.android.domain.community.model.tmap.FullTextGeocoding

import com.fasterxml.jackson.annotation.JsonProperty

data class CoordinateItem(

    @field:JsonProperty("matchFlag")
    val matchFlag: String? = null,

    @field:JsonProperty("lon")
    val lon: String? = null,

    @field:JsonProperty("latEntr")
    val latEntr: String? = null,

    @field:JsonProperty("city_do")
    val cityDo: String? = null,

    @field:JsonProperty("gu_gun")
    val guGun: String? = null,

    @field:JsonProperty("adminDongCode")
    val adminDongCode: String? = null,

    @field:JsonProperty("legalDongCode")
    val legalDongCode: String? = null,

    @field:JsonProperty("lat")
    val lat: String? = null,

    @field:JsonProperty("bunji")
    val bunji: String? = null,

    @field:JsonProperty("newLat")
    val newLat: String? = null,

    @field:JsonProperty("newRoadName")
    val newRoadName: String? = null,

    @field:JsonProperty("lonEntr")
    val lonEntr: String? = null,

    @field:JsonProperty("newMatchFlag")
    val newMatchFlag: String? = null,

    @field:JsonProperty("newBuildingIndex")
    val newBuildingIndex: String? = null,

    @field:JsonProperty("newLon")
    val newLon: String? = null,

    @field:JsonProperty("zipcode")
    val zipcode: String? = null,

    @field:JsonProperty("buildingName")
    val buildingName: String? = null,

    @field:JsonProperty("legalDong")
    val legalDong: String? = null,

    @field:JsonProperty("buildingDong")
    val buildingDong: String? = null,

    @field:JsonProperty("adminDong")
    val adminDong: String? = null,

    @field:JsonProperty("newBuildingName")
    val newBuildingName: String? = null,

    @field:JsonProperty("ri")
    val ri: String? = null,

    @field:JsonProperty("eup_myun")
    val eupMyun: String? = null,

    @field:JsonProperty("newBuildingCateName")
    val newBuildingCateName: String? = null,

    @field:JsonProperty("newLatEntr")
    val newLatEntr: String? = null,

    @field:JsonProperty("newBuildingDong")
    val newBuildingDong: String? = null,

    @field:JsonProperty("remainder")
    val remainder: String? = null,

    @field:JsonProperty("newLonEntr")
    val newLonEntr: String? = null
)
