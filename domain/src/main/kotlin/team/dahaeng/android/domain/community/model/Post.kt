/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Post.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model

import kotlin.random.Random
import team.dahaeng.android.domain.community.model.travel.Theme
import team.dahaeng.android.domain.community.model.travel.Period
import team.dahaeng.android.domain.community.model.travel.Travel

data class Post(
    val id: Int = Random.nextInt(),
    val imageUrl: String = "",
    val title: String = "",
    val content: String = "",
    val travel: Travel
)
