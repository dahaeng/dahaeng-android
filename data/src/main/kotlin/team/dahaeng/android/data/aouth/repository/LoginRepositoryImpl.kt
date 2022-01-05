/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepositoryImpl.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:37
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.aouth.repository

import android.content.Context
import com.kakao.sdk.user.UserApiClient
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.aouth.mapper.toLoginResult
import team.dahaeng.android.data.aouth.model.UserResponse
import team.dahaeng.android.domain.aouth.model.LoginResult
import team.dahaeng.android.domain.aouth.repository.LoginRepository
import kotlin.coroutines.resume

private const val RESPONSE_NOTHING = "Kakao API response is nothing."

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(context: Context): LoginResult {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        } else {
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                if (error != null) {
                    event(LoginEvent.Error(error))
                } else if (token != null) {
                    event(LoginEvent.Success(token))
                }
            }
        }
    }

    private suspend fun loginWithKakaoTalk(context: Context): LoginResult =
        suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                continuation.resume(
                    when {
                        error != null -> LoginResult(exception = error)
                        token != null -> {
                            getUserModel {
                                it.toLoginResult()
                            }
                        }
                        else -> LoginResult(exception = Throwable(RESPONSE_NOTHING))
                    }
                )
            }
        }

    private fun <T> getUserModel(action: (UserResponse) -> T): T {
        UserApiClient.instance.me { user, error ->
            action(
                when {
                    error != null -> UserResponse(exception = error)
                    user != null -> UserResponse(user = user)
                    else -> UserResponse(exception = Throwable(RESPONSE_NOTHING))
                }
            )
        }
    }
}
