/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Transportation.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:50
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import java.io.Serializable

@JvmInline
value class Transportation(val value: String) : Serializable {
    companion object {
        val None = Transportation("")
        val Random get() = TransportationList.All.random()
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object TransportationList {
    val Car = Transportation("자동차")
    val Bus = Transportation("버스")
    val Subway = Transportation("지하철")
    val Plane = Transportation("비행기")
    val Ship = Transportation("배")
    val All = listOf(Car, Bus, Subway, Plane, Ship)

    fun Other(transportation: String) = Transportation(transportation)
}
