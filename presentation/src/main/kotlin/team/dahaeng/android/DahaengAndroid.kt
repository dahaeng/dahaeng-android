/*
 * Dahaeng © 2021 Ji Sungbin, jkey20. all rights reserved.
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

@HiltAndroidApp
class DahaengAndroid : Application() {
    override fun onCreate() {
        super.onCreate()

        Erratum.setup(this) // TODO: Exception activity
        if (BuildConfig.DEBUG) {
            Logeukes.setup()
        }
    }
}
