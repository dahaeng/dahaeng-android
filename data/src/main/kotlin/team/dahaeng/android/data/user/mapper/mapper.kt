/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [mapper.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:56
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.user.mapper

import com.kakao.sdk.user.model.User
import kotlin.random.Random
import team.dahaeng.android.data.util.DefaultUserConfig
import team.dahaeng.android.domain.user.model.KakaoProfile

internal fun User.toDomain() = KakaoProfile(
    id = id ?: Random.nextLong(),
    nickname = kakaoAccount?.profile?.nickname ?: DefaultUserConfig.randomNickname,
    profileImageSrc = kakaoAccount?.profile?.profileImageUrl
        ?: DefaultUserConfig.randomColorDrawable
)
