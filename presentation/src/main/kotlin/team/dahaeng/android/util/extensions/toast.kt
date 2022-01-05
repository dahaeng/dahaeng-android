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
