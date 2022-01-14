/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Theme.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:44
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

@JvmInline
value class Theme(val value: String) {
    companion object {
        val NONE = Theme("")
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object ThemeList {
    val Pension = Theme("펜션")
    val Camping = Theme("캠핑")
    val Sport = Theme("스포츠")
    val Healing = Theme("힐링")
    val All = listOf(Pension, Camping, Sport, Healing).map(Theme::value)

    fun Other(theme: String) = Theme(theme)
}
