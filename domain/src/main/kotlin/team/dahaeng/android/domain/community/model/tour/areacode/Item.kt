package team.dahaeng.android.domain.community.model.tour.areacode

import com.fasterxml.jackson.annotation.JsonProperty


data class Item(
    @field:JsonProperty("rnum")
    val rnum: Int? = null,

    @field:JsonProperty("code")
    val code: Int? = null,

    @field:JsonProperty("name")
    val name: String? = null
)