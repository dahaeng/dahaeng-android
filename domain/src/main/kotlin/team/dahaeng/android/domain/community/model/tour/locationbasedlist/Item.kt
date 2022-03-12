package team.dahaeng.android.domain.community.model.tour.locationbasedlist

import com.fasterxml.jackson.annotation.JsonProperty


data class Item(

    @field:JsonProperty("readcount")
    val readcount: Int? = null,

    @field:JsonProperty("addr1")
    val addr1: String? = null,

    @field:JsonProperty("contentid")
    val contentid: Int? = null,

    @field:JsonProperty("dist")
    val dist: Int? = null,

    @field:JsonProperty("firstimage2")
    val firstimage2: String? = null,

    @field:JsonProperty("title")
    val title: String? = null,

    @field:JsonProperty("areacode")
    val areacode: Int? = null,

    @field:JsonProperty("createdtime")
    val createdtime: Long? = null,

    @field:JsonProperty("mapy")
    val mapy: Double? = null,

    @field:JsonProperty("contenttypeid")
    val contenttypeid: Int? = null,

    @field:JsonProperty("mapx")
    val mapx: String? = null,

    @field:JsonProperty("cat2")
    val cat2: String? = null,

    @field:JsonProperty("cat3")
    val cat3: String? = null,

    @field:JsonProperty("modifiedtime")
    val modifiedtime: Long? = null,

    @field:JsonProperty("cat1")
    val cat1: String? = null,

    @field:JsonProperty("mlevel")
    val mlevel: Int? = null,

    @field:JsonProperty("sigungucode")
    val sigungucode: Int? = null,

    @field:JsonProperty("tel")
    val tel: String? = null,

    @field:JsonProperty("firstimage")
    val firstimage: String? = null,

    @field:JsonProperty("addr2")
    val addr2: String? = null
)
