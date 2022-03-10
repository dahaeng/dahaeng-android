/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ScheduleCreateActivity.kt] created by Ji Sungbin on 22. 3. 10. 오후 8:32
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.schedule.create

import androidx.activity.viewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityScheduleCreateBinding

class ScheduleCreateActivity : BaseActivity<ActivityScheduleCreateBinding, ScheduleCreateViewModel>(
    R.layout.activity_schedule_create
) {
    override val vm: ScheduleCreateViewModel by viewModels()
}
