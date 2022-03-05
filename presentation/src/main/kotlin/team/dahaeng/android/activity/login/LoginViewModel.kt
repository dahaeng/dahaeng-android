/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.app.Activity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.user.model.User
import team.dahaeng.android.domain.user.usecase.GetUserUseCase
import team.dahaeng.android.domain.user.usecase.KakaoLoginUseCase
import team.dahaeng.android.domain.user.usecase.UpdateUserUseCase

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val kakaoLoginUseCase: KakaoLoginUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val getUserUseCase: GetUserUseCase,
) : BaseViewModel() {

    suspend fun login(activity: Activity) = kakaoLoginUseCase(activity).getOrElse { exception ->
        emitException(exception)
        null
    }

    suspend fun updateUser(user: User) = updateUserUseCase(user).getOrElse { exception ->
        emitException(exception)
        null
    }

    suspend fun getUser(userId: Long) = getUserUseCase(userId).getOrElse { exception ->
        emitException(exception)
        null
    }
}
