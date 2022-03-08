package team.dahaeng.android.domain.community.repository

interface TourRepository {
    suspend fun importTourData() : String
}