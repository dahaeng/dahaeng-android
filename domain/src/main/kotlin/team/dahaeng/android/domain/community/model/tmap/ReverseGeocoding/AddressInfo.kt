package team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding

import com.fasterxml.jackson.annotation.JsonProperty


data class AddressInfo(

    @field:JsonProperty("bunji")
    val bunji: String? = null,

    @field:JsonProperty("addressKey")
    val addressKey: String? = null,

    @field:JsonProperty("addressType")
    val addressType: String? = null,

    @field:JsonProperty("roadCode")
    val roadCode: String? = null,

    @field:JsonProperty("roadName")
    val roadName: String? = null,

    @field:JsonProperty("city_do")
    val cityDo: String? = null,

    @field:JsonProperty("gu_gun")
    val guGun: String? = null,

    @field:JsonProperty("buildingName")
    val buildingName: String? = null,

    @field:JsonProperty("roadAddressKey")
    val roadAddressKey: String? = null,

    @field:JsonProperty("legalDong")
    val legalDong: String? = null,

    @field:JsonProperty("mappingDistance")
    val mappingDistance: Int? = null,

    @field:JsonProperty("roadCoord")
    val roadCoord: RoadCoord? = null,

    @field:JsonProperty("adminDong")
    val adminDong: String? = null,

    @field:JsonProperty("adminDongCode")
    val adminDongCode: String? = null,

    @field:JsonProperty("ri")
    val ri: String? = null,

    @field:JsonProperty("fullAddress")
    val fullAddress: String? = null,

    @field:JsonProperty("eup_myun")
    val eupMyun: String? = null,

    @field:JsonProperty("legalDongCoord")
    val legalDongCoord: LegalDongCoord? = null,

    @field:JsonProperty("legalDongCode")
    val legalDongCode: String? = null,

    @field:JsonProperty("adminDongCoord")
    val adminDongCoord: AdminDongCoord? = null,

    @field:JsonProperty("buildingIndex")
    val buildingIndex: String? = null
)