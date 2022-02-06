/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [KakaoLoginUseCase.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:33
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.usecase

import android.content.Context
import team.dahaeng.android.domain.aouth.repository.AouthRepository

class KakaoLoginUseCase(private val repository: AouthRepository, private val context: Context) {
    suspend operator fun invoke() = runCatching {
        repository.kakaoLogin(context)
    }
}
