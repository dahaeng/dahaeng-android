/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ViewScheduleActivity.kt] created by Ji Sungbin on 22. 3. 5. 오후 11:43
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.schedule.viewer

import androidx.activity.viewModels
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityScheduleViewBinding

class ScheduleViewActivity : BaseActivity<ActivityScheduleViewBinding, ScheduleViewViewModel>(
    R.layout.activity_schedule_view
) {
    override val vm: ScheduleViewViewModel by viewModels()
}
