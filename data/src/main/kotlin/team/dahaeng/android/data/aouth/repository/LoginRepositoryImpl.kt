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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import team.dahaeng.android.data.aouth.mapper.toLoginResult
import team.dahaeng.android.data.aouth.model.UserResponse
import team.dahaeng.android.domain.aouth.model.LoginResult
import team.dahaeng.android.domain.aouth.repository.LoginRepository
import kotlin.coroutines.resume

private const val RESPONSE_NOTHING = "Kakao API response is nothing."

class LoginRepositoryImpl : LoginRepository {
    override suspend fun login(context: Context): LoginResult {
        val loginResult = withContext(Dispatchers.IO) {
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                loginWithKakaoTalk(context)
            } else {
                loginWithWebView(context)
            }
        }
        return if (loginResult.isFailure()) {
            loginResult // 로그인에서 실패했으므로 실패한 정보 바로 보내기
        } else {
            getUser().toLoginResult() // 로그인에 성공했으므로 유저 정보 가져와서 보내기
        }
    }

    private suspend fun loginWithKakaoTalk(context: Context): LoginResult =
        suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                continuation.resume(
                    when {
                        error != null -> LoginResult(exception = error)
                        token != null -> LoginResult()
                        else -> LoginResult(exception = Throwable(RESPONSE_NOTHING))
                    }
                )
            }
        }

    private suspend fun loginWithWebView(context: Context): LoginResult =
        suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                continuation.resume(
                    when {
                        error != null -> LoginResult(exception = error)
                        token != null -> LoginResult()
                        else -> LoginResult(exception = Throwable(RESPONSE_NOTHING))
                    }
                )
            }
        }

    private suspend fun getUser(): UserResponse = suspendCancellableCoroutine { continuation ->
        UserApiClient.instance.me { user, error ->
            continuation.resume(
                when {
                    error != null -> UserResponse(exception = error)
                    user != null -> UserResponse(user = user)
                    else -> UserResponse(exception = Throwable(RESPONSE_NOTHING))
                }
            )
        }
    }
}
