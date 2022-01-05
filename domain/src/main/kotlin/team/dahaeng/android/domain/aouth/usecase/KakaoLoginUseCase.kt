/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [KakaoLoginUseCase.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:33
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.aouth.usecase

import android.content.Context
import team.dahaeng.android.domain.aouth.model.LoginResult
import team.dahaeng.android.domain.aouth.repository.LoginRepository

class KakaoLoginUseCase(private val repository: LoginRepository) {
    operator fun invoke(context: Context) = try {
        repository.login(context)
    } catch (exception: Exception) {
        LoginResult(exception = exception)
    }
}
