package team.dahaeng.android.ui.smoothbottombar

import android.graphics.RectF
import android.graphics.drawable.Drawable

// https://github.com/ibrahimsn98/SmoothBottomBar/tree/0daaf9dca4ed63b0ff79069687d4ae9e52cfa8b6
data class BottomBarItem(
    var title: String,
    var contentDescription: String,
    val icon: Drawable,
    var rect: RectF = RectF(),
    var alpha: Int
)
