/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Theme.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:44
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

import java.io.Serializable

/**
 * 테마 객체
 *
 * value class 로 하게 되면 Firestore 에서 object 변환할 때 값 주입을 못하게 됨
 */
data class Theme(val value: String = "") : Serializable {
    companion object {
        val Random get() = ThemeList.All.random()
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object ThemeList {
    val Pension = Theme("펜션")
    val Camping = Theme("캠핑")
    val Sport = Theme("스포츠")
    val Healing = Theme("힐링")
    val All = listOf(Pension, Camping, Sport, Healing)

    fun Other(theme: String) = Theme(theme)
}
