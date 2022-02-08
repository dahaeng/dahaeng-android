/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyScheduleActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.databinding.ActivityModifyScheduleBinding
import team.dahaeng.android.domain.community.model.Schedule

@AndroidEntryPoint
class ModifyScheduleActivity : BaseActivity<ActivityModifyScheduleBinding, MainViewModel>(
    R.layout.activity_modify_schedule
) {

    override val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.schedule = Schedule()
        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_theme_array,
            android.R.layout.simple_dropdown_item_1line
        )

    }

}