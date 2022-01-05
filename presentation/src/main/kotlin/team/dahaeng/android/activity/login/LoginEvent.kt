/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [LoginEvent.kt] created by Ji Sungbin on 22. 1. 5. 오후 10:35
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.login

import com.kakao.sdk.auth.model.OAuthToken
import team.dahaeng.android.activity.base.BaseEvent

sealed class LoginEvent : BaseEvent {
    data class Error(val cause: Throwable) : LoginEvent()
    data class Success(val token: OAuthToken) : LoginEvent()
}
