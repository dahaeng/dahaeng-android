/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingFragment.kt] created by Ji Sungbin on 22. 1. 18. 오후 9:09
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.main.fragment.like

import androidx.fragment.app.activityViewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseFragment
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.databinding.FragmentLikeBinding

class LikeFragment : BaseFragment<FragmentLikeBinding, MainViewModel>(R.layout.fragment_like) {
    override val vm: MainViewModel by activityViewModels()
}
