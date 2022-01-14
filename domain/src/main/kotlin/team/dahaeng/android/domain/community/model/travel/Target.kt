/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Target.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:48
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

@JvmInline
value class Target(val value: String) {
    companion object {
        val NONE = Target("")
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object TargetList {
    val Parent = Target("부모님")
    val Friend = Target("친구")
    val Lover = Target("애인")
    val All = listOf(Parent, Friend, Lover).map(Target::value)

    fun Other(target: String) = Target(target)
}
