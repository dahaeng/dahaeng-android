/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [kakaoProfileToUserMapper.kt] created by Ji Sungbin on 22. 3. 5. 오후 10:14
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.mapper

import team.dahaeng.android.domain.user.model.KakaoProfile
import team.dahaeng.android.domain.user.model.User

fun KakaoProfile.toUser() = User(
    id = id,
    nickname = nickname,
    profileImageSrc = profileImageSrc,
)
