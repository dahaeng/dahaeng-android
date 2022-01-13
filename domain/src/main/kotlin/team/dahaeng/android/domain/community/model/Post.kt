/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Post.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model

data class Post(
    val imgUrl: String = "",
    val title: String = "",
    val content: String = "",
    val expense: String = "",
    val period: String = "",
    val tagTheme: String = "",
    val id: String = ""
)
