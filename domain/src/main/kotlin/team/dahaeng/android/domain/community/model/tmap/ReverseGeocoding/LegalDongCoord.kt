package team.dahaeng.android.domain.community.model.tmap.ReverseGeocoding

import com.fasterxml.jackson.annotation.JsonProperty


data class LegalDongCoord(

    @field:JsonProperty("lonEntr")
    val lonEntr: String? = null,

    @field:JsonProperty("lon")
    val lon: String? = null,

    @field:JsonProperty("latEntr")
    val latEntr: String? = null,

    @field:JsonProperty("lat")
    val lat: String? = null
)
