package team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding

import com.fasterxml.jackson.annotation.JsonProperty

data class ReverseGeocodingResponse(

	@field:JsonProperty("addressInfo")
	val addressInfo: AddressInfo? = null
)



