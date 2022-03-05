/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [KakaoLoginUseCase.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:33
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.user.usecase

import android.app.Activity
import team.dahaeng.android.domain.user.repository.UserRepository

class KakaoLoginUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(activity: Activity) = runCatching {
        repository.kakaoLogin(activity)
    }
}
