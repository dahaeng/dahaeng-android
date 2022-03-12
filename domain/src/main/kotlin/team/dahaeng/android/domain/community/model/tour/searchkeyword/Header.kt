package team.dahaeng.android.domain.community.model.tour.searchkeyword

import com.fasterxml.jackson.annotation.JsonProperty

data class Header(
    @field:JsonProperty("resultCode")
    val resultCode: String? = null,

    @field:JsonProperty("resultMsg")
    val resultMsg: String? = null
)