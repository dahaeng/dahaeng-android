package team.dahaeng.android.domain.community.model.tour.areabasedlist

import com.fasterxml.jackson.annotation.JsonProperty

data class AreaBasedListResponse(
    @field:JsonProperty("response")
    val response: Response? = null,
)
