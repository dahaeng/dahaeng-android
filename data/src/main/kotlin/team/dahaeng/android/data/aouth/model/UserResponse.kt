/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [UserResponse.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:50
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.aouth.model

import com.kakao.sdk.user.model.User
import team.dahaeng.android.domain.util.BaseModel

data class UserResponse(override val exception: Throwable? = null, val user: User? = null) :
    BaseModel
