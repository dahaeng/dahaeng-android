/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Post.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model

import team.dahaeng.android.domain.community.model.travel.Travel
import java.util.Date
import kotlin.random.Random

data class Post(
    val id: Long = Random.nextLong(),
    val title: String = "",
    val content: String = "",
    val travel: Travel = Travel(),
    val createdAt: Long = Date().time,
    val images: List<String> = emptyList(),
)
