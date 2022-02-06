/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [TaskingActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.tasking

import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.lifecycle.HiltViewModel
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityTaskingBinding

@HiltViewModel
class TaskingActivity : BaseActivity<ActivityTaskingBinding, TaskingViewModel>(
    R.layout.activity_tasking
) {
    override val vm: TaskingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
