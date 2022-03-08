package team.dahaeng.android.domain.community.model.tmap

data class Coordinate (
    val matchFlag: String,
    val lat: Number,
    val lon: Number,
    val city_do: String,
    val gu_gun: String,
    val eup_myun: String,
    val legalDong: String,
    val adminDong: String,
    val ri: String,
    val bunji: String,
    val newMatchFlag : String,
    val newLat : Number,
    val newLon : Number,
    val newRoadName : String,
    val newBuildingIndex : String,
    val remainder : String,
)
