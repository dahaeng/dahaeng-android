package team.dahaeng.android.domain.community.model.tour.areacode

import com.fasterxml.jackson.annotation.JsonProperty


data class Body(
    @field:JsonProperty("pageNo")
    val pageNo: Int? = null,

    @field:JsonProperty("totalCount")
    val totalCount: Int? = null,

    @field:JsonProperty("items")
    val items: Items? = null,

    @field:JsonProperty("numOfRows")
    val numOfRows: Int? = null
)
