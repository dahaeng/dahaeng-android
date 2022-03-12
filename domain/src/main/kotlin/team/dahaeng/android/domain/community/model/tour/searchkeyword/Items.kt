package team.dahaeng.android.domain.community.model.tour.searchkeyword

import com.fasterxml.jackson.annotation.JsonProperty

data class Items(
    @field:JsonProperty("item")
    val item: List<Item?>? = null
)