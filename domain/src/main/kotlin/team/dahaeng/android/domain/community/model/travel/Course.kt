/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Course.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import java.io.Serializable

data class Course(
    val transportation: Transportation = Transportation(),
    val period: Period = Period(),
    val place: Place = Place(),
    val accommodation: Accommodation = Accommodation(),
) : Serializable
