/*
 * Dahaeng © 2022 Ji Sungbin, jkey20. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [toast.kt] created by Ji Sungbin
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun toast(context: Context, message: String, length: Int) {
    Toast.makeText(context, message, length).show()
}

fun toast(activity: Activity, message: String, length: Int) {
    activity.runOnUiThread {
        Toast.makeText(activity, message, length).show()
    }
}

fun Fragment.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    toast(requireActivity(), message, length)
}

@JvmName("ActivityToastExtension")
fun Activity.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    toast(this, message, length)
}
