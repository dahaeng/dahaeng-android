/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:26
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import android.content.Context
import com.kakao.sdk.user.UserApiClient
import team.dahaeng.android.activity.base.BaseViewModel

class LoginViewModel : BaseViewModel<LoginEvent>() {
    fun login(context: Context) {
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    event(LoginEvent.Error(error))
                } else if (token != null) {
                    event(LoginEvent.Success(token))
                }
            }
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
}