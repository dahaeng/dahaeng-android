/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Target.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import java.io.Serializable

/**
 * 타켓 객체
 *
 * value class 로 하게 되면 Firestore 에서 object 변환할 때 값 주입을 못하게 됨
 */
data class Target(val value: String = "") : Serializable {
    companion object {
        val Random get() = TargetList.All.random()
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object TargetList {
    val Parent = Target("부모님")
    val Friend = Target("친구")
    val Lover = Target("애인")
    val All = listOf(Parent, Friend, Lover)

    fun Other(target: String) = Target(target)
}
