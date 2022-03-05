/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginRepositoryImpl.kt] created by Ji Sungbin on 22. 1. 6. 오전 1:37
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.user.repository

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.User
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlinx.coroutines.suspendCancellableCoroutine
import team.dahaeng.android.data.user.mapper.toDomain
import team.dahaeng.android.data.util.Constants
import team.dahaeng.android.data.util.UserDomain
import team.dahaeng.android.data.util.toObjectNonNull
import team.dahaeng.android.domain.user.model.KakaoProfile
import team.dahaeng.android.domain.user.repository.UserRepository

private const val RESPONSE_NOTHING = "Kakao API response is nothing."

class UserRepositoryImpl(private val context: Context) : UserRepository {

    private val firestore by lazy { Firebase.firestore }

    private fun FirebaseFirestore.setUserPath(user: UserDomain) =
        collection(Constants.Firestore.User)
            .document(user.id.toString())

    private fun FirebaseFirestore.setUserPath(id: Long) =
        collection(Constants.Firestore.User)
            .document(id.toString())

    override suspend fun kakaoLogin(): KakaoProfile {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            loginWithKakaoTalk()
        } else {
            loginWithWebView()
        }
        return getUser().toDomain()
    }

    override suspend fun updateUser(user: UserDomain) {
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore
                .setUserPath(user)
                .set(user)
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }

    override suspend fun removeUser(userId: Long) {
        suspendCancellableCoroutine<Unit> { continuation ->
            firestore
                .setUserPath(userId)
                .delete()
                .addOnSuccessListener {
                    continuation.resume(Unit)
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
        }
    }

    override suspend fun getUser(userId: Long): UserDomain =
        suspendCancellableCoroutine { continuation ->
            firestore
                .setUserPath(userId)
                .get()
                .addOnSuccessListener { result ->
                    continuation.resume(result.toObjectNonNull())
                }
                .addOnFailureListener { exception ->
                    continuation.resumeWithException(exception)
                }
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
