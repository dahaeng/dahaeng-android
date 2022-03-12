package team.dahaeng.android.domain.community.model.tour.locationbasedlist

import com.fasterxml.jackson.annotation.JsonProperty

data class LocationBasedListResponse(
    @field:JsonProperty("response")
    val response: Response? = null,
)
