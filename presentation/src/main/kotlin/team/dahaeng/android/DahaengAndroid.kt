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
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp
import io.github.jisungbin.erratum.Erratum
import io.github.jisungbin.erratum.ErratumExceptionActivity
import io.github.jisungbin.logeukes.Logeukes
import team.dahaeng.android.activity.error.ErrorActivity
import team.dahaeng.android.data.util.DataLayerUtil
import team.dahaeng.android.util.constants.Key

// TODO: firebase analytics
@HiltAndroidApp
class DahaengAndroid : Application() {
    override fun onCreate() {
        super.onCreate()

        Erratum.setup(
            application = this,
            registerExceptionActivityIntent = { _, throwable, lastActivity ->
                Intent(lastActivity, ErrorActivity::class.java).apply {
                    putExtra(ErratumExceptionActivity.EXTRA_EXCEPTION_STRING, throwable.toString())
                    putExtra(
                        ErratumExceptionActivity.EXTRA_LAST_ACTIVITY_INTENT,
                        lastActivity.intent
                    )
                    putExtra(Key.Intent.Error, Key.Intent.Exception)
                }
            }
        )
        DataLayerUtil.initKakaoSdk(this, BuildConfig.KAKAO_API_KEY)
        if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }
    }
}
