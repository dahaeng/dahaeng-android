/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TransportationList.kt] created by Ji Sungbin on 22. 3. 8. 오후 9:18
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.schedule.model.travel.wrapper

import team.dahaeng.android.domain.schedule.model.travel.Transportation

/**
 * 교통 수단 리스트 wrapper
 */
data class TransportationList(
    val list: List<Transportation> = emptyList(),
)
