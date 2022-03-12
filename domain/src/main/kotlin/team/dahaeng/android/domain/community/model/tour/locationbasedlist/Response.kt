package team.dahaeng.android.domain.community.model.tour.locationbasedlist

import com.fasterxml.jackson.annotation.JsonProperty

data class Response(
	@field:JsonProperty("header")
	val header: Header? = null,

	@field:JsonProperty("body")
	val body: Body? = null
)

