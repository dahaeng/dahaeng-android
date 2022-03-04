/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
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

fun Activity.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = applicationContext,
    message = message,
    length = length
)

fun Fragment.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = requireContext(),
    message = message,
    length = length
)

fun toast(
    context: Context,
    messageBuilder: Context.() -> String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = context,
    message = messageBuilder(context),
    length = length
)

fun toast(
    context: Context,
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = context,
    message = message,
    length = length
)

private fun toastBuilder(
    context: Context,
    message: String,
    length: Int,
) {
    Toast.makeText(context, message, length).show()
}
