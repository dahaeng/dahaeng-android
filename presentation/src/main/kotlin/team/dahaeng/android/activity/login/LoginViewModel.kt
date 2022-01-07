/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.content.Context
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.aouth.usecase.KakaoLoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val kakaoLoginUseCase: KakaoLoginUseCase) :
    BaseViewModel<LoginEvent>() {

    fun login(context: Context) = viewModelScope.launch {
        val result = kakaoLoginUseCase(context)
        if (result.isFailure()) {
            logeukes(type = LoggerType.E) { result.exception }
            emitEvent(LoginEvent.Failure)
        } else {
            emitEvent(LoginEvent.Success(result.user!!))
        }
    }
}
