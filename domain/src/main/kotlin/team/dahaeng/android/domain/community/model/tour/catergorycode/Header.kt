package team.dahaeng.android.domain.community.model.tour.catergorycode

import com.fasterxml.jackson.annotation.JsonProperty

data class Header(
    @field:JsonProperty("resultCode")
    val resultCode: String? = null,

    @field:JsonProperty("resultMsg")
    val resultMsg: String? = null
)