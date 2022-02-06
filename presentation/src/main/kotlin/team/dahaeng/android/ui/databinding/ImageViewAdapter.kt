/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ImageViewAdapter.kt] created by Ji Sungbin on 22. 1. 19. 오후 2:06
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.ui.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.findViewTreeLifecycleOwner
import coil.loadAny
import coil.request.CachePolicy
import team.dahaeng.android.R

@BindingAdapter("with_glide_small")
fun loadSrcWithGlideSmallSize(view: ImageView, src: Any) {
    view.loadAny(src) {
        crossfade(true)
        placeholder(R.drawable.ic_round_airplane_ticket_24)
        lifecycle(view.findViewTreeLifecycleOwner())
        allowRgb565(true)
        diskCachePolicy(CachePolicy.ENABLED)
    }
}

@BindingAdapter("with_glide_big")
fun loadSrcWithGlideBigSize(view: ImageView, src: Any) {
    view.loadAny(src) {
        crossfade(true)
        placeholder(R.drawable.ic_round_airplane_ticket_24)
        lifecycle(view.findViewTreeLifecycleOwner())
    }
}
