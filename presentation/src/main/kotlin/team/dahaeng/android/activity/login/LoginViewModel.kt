/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
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
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.aouth.usecase.KakaoLoginUseCase
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val dispatcher: CoroutineDispatcher
) : BaseViewModel<LoginEvent>() {
    suspend fun login(context: Context) = viewModelScope.launch {
        kakaoLoginUseCase(context, dispatcher)
            .onSuccess { user ->
                emitEvent(LoginEvent.Success(user))
            }
            .onFailure { exception ->
                logeukes(type = LoggerType.E) { exception }
                emitEvent(LoginEvent.Failure)
            }
    }
}
