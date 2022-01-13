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
import kotlinx.coroutines.CoroutineDispatcher
import team.dahaeng.android.domain.aouth.repository.AouthRepository

class KakaoLoginUseCase(private val repository: AouthRepository) {
    suspend operator fun invoke(context: Context, dispatcher: CoroutineDispatcher) = runCatching {
        repository.kakaoLogin(context, dispatcher)
    }
}
