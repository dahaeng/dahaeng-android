/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Util.kt] created by Ji Sungbin on 22. 1. 14. 오후 5:56
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.util

import android.content.Context
import com.kakao.sdk.common.KakaoSdk

object Util {
    fun initKakaoSdk(context: Context, apiKey: String) {
        KakaoSdk.init(context, apiKey)
    }
}
