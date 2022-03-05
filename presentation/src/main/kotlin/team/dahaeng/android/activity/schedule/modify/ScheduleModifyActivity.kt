/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ScheduleCreateActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.schedule.modify

import androidx.activity.viewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityScheduleModifyBinding

class ScheduleModifyActivity : BaseActivity<ActivityScheduleModifyBinding, ScheduleModifyViewModel>(
    R.layout.activity_schedule_modify
) {
    override val vm: ScheduleModifyViewModel by viewModels()
}
