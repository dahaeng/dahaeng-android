/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [DahaengAndroid.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:51
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.github.jisungbin.erratum.Erratum
import io.github.jisungbin.logeukes.Logeukes
import team.dahaeng.android.data.util.initKakaoSdk

@HiltAndroidApp
class DahaengAndroid : Application() {
    override fun onCreate() {
        super.onCreate()

        Erratum.setup(this) // TODO: Exception activity
        initKakaoSdk(this, BuildConfig.KAKAO_API_KEY)
        if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }
    }
}
