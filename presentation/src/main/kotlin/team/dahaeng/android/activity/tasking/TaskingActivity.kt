/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.tasking

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityTaskingBinding

@AndroidEntryPoint
class TaskingActivity : BaseActivity<ActivityTaskingBinding, TaskingViewModel>(
    R.layout.activity_tasking
) {
    override val vm: TaskingViewModel by viewModels()
}
