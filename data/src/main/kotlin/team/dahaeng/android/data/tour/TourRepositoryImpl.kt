package team.dahaeng.android.data.tour

import android.util.Log
import team.dahaeng.android.data.api.TourApi
import team.dahaeng.android.domain.community.repository.TourRepository

class TourRepositoryImpl(private val api: TourApi) : TourRepository {
    override suspend fun importTourData(): String {
        var data = api.getTourData(
            MobileOs = "AND",
            MobileApp = "AppTest"
        )
        Log.i("TOURDATA", data)
        return ""
    }


}