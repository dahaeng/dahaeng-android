/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepositoryImpl.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:37
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.aouth.repository

import android.content.Context
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import team.dahaeng.android.data.aouth.mapper.toDomain
import team.dahaeng.android.data.util.UserDomain
import team.dahaeng.android.domain.aouth.repository.AouthRepository
import kotlin.coroutines.resume

private const val RESPONSE_NOTHING = "Kakao API response is nothing."

class AouthRepositoryImpl : AouthRepository {
    override suspend fun kakaoLogin(context: Context, dispatcher: CoroutineDispatcher): UserDomain {
        withContext(dispatcher) {
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
                loginWithKakaoTalk(context)
            } else {
                loginWithWebView(context)
            }
        }
        return getUser().toDomain()
    }

    private suspend fun loginWithKakaoTalk(context: Context): Unit =
        suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                continuation.resume(
                    when {
                        error != null -> throw error
                        token != null -> Unit
                        else -> throw Throwable(RESPONSE_NOTHING)
                    }
                )
            }
        }

    private suspend fun loginWithWebView(context: Context): Unit =
        suspendCancellableCoroutine { continuation ->
            UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
                continuation.resume(
                    when {
                        error != null -> throw error
                        token != null -> Unit
                        else -> throw Throwable(RESPONSE_NOTHING)
                    }
                )
            }
        }

    private suspend fun getUser(): User = suspendCancellableCoroutine { continuation ->
        UserApiClient.instance.me { user, error ->
            continuation.resume(
                when {
                    error != null -> throw error
                    user != null -> user
                    else -> throw Throwable(RESPONSE_NOTHING)
                }
            )
        }
    }
}
