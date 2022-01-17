package team.dahaeng.android.ui.smoothbottombar

import android.content.Context
import kotlin.math.roundToInt

// https://github.com/ibrahimsn98/SmoothBottomBar/tree/0daaf9dca4ed63b0ff79069687d4ae9e52cfa8b6
fun Context.d2p(dp: Float) = (dp * resources.displayMetrics.density).roundToInt().toFloat()
