/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [mapper.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:56
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.aouth.mapper

import com.kakao.sdk.user.model.User
import team.dahaeng.android.data.UserDomain

fun User.toDomain() = UserDomain(
    nickname = kakaoAccount?.profile?.nickname ?: UserDomain.getDefaultNickname(),
    profileImageUrl = kakaoAccount?.profile?.profileImageUrl
        ?: UserDomain.getDefaultProfileImageColor()
)
