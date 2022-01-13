/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [PostResult.kt] created by Ji Sungbin on 22. 1. 13. 오후 5:51
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model

import team.dahaeng.android.domain.util.BaseModel

data class PostResult(override val exception: Throwable? = null, val posts: List<Post>? = null) :
    BaseModel
