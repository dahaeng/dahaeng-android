/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.user.usecase.KakaoLoginUseCase

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
) : BaseViewModel() {

    suspend fun login() = kakaoLoginUseCase().getOrElse { exception ->
        emitException(exception)
        null
    }
}
