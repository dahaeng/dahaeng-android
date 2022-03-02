/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TestUtil.kt] created by Ji Sungbin on 22. 1. 19. 오후 5:13
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.test

import team.dahaeng.android.domain.community.model.post.Post
import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Target
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Transportation
import team.dahaeng.android.domain.community.model.travel.Travel
import team.dahaeng.android.domain.community.model.schedule.Schedule
import java.util.Date
import kotlin.random.Random

object TestUtil {
    private const val TestImageUrl =
        "https://images.unsplash.com/photo-1523906834658-6e24ef2386f9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1283&q=80"

/*    fun posts(count: Int = 10) = List(count) { index ->
        Post(
            title = "여행지 - $index",
            content = "이것은 아름다운 ${index}번째 여행지 입니다.",
            travel = Travel(
                totalPrice = Random.nextLong(10_000, 1_000_000_000),
                transportation = Transportation.Random,
                period = Period(from = "어제", to = "내일"),
                places = listOf(),
                photos = listOf(TestImageUrl),
                theme = Theme.Random,
                target = Target.Random,
                commonAddress = "서울시 한강로"
            ),
            createdAt = Date().time
        )
    }

    fun schedules(count: Int = 10) = List(count) { index ->
        Schedule(
            participant = listOf(),
            title = "제주 레포츠렌드 - $index",
            theme = "",
            totalPrice = 0,
            transportation = "",
            period = Period(from = "", to = ""),
            photos = listOf(),
            places = listOf(),
            accommodation = ""
        )
    }
*/
}

