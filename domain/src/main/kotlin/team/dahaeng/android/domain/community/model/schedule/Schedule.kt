/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Schedule.kt] created by Ji Sungbin on 22. 2. 4. 오전 12:42
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.schedule

import team.dahaeng.android.domain.community.model.travel.Travel
import java.io.Serializable
import kotlin.random.Random

/**
 * 일정 객체
 *
 * @property id 일정 UUID
 * @property participant 일정 참여자 UUID 리스트, <b>첫 요소는 무조건 해당 일정의 owner 임</b>
 * @property title 일정 제목
 * @property travel 일정동안 쓰일 여행지 객체
 */
data class Schedule(
    val id: Long = Random.nextLong(),
    val participant: List<Long> = emptyList(),
    var title: String = "",
    var travel: Travel = Travel(),
) : Serializable
