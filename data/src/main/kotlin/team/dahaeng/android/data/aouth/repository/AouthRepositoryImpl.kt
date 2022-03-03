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
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.aouth.mapper.toDomain
import team.dahaeng.android.data.util.UserDomain
import team.dahaeng.android.domain.aouth.repository.AouthRepository
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

private const val RESPONSE_NOTHING = "Kakao API response is nothing."

class AouthRepositoryImpl(private val context: Context) : AouthRepository {
    override suspend fun kakaoLogin(): UserDomain {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            loginWithKakaoTalk()
        } else {
            loginWithWebView()
        }
        return getUser().toDomain()
    }

    private suspend fun loginWithKakaoTalk(): Unit = suspendCancellableCoroutine { continuation ->
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            when {
                token != null -> continuation.resume(Unit)
                error != null -> continuation.resumeWithException(error)
                else -> continuation.resumeWithException(Exception(RESPONSE_NOTHING))
            }
        }
    }

    private suspend fun loginWithWebView(): Unit = suspendCancellableCoroutine { continuation ->
        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            when {
                token != null -> continuation.resume(Unit)
                error != null -> continuation.resumeWithException(error)
                else -> continuation.resumeWithException(Exception(RESPONSE_NOTHING))
            }
        }
    }

    private suspend fun getUser(): User = suspendCancellableCoroutine { continuation ->
        UserApiClient.instance.me { user, error ->
            when {
                user != null -> continuation.resume(user)
                error != null -> continuation.resumeWithException(error)
                else -> continuation.resumeWithException(Exception(RESPONSE_NOTHING))
            }
        }
    }
}
