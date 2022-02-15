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
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.activity.main.MainViewModel
import team.dahaeng.android.data.DataStore
import team.dahaeng.android.databinding.ActivityModifyScheduleBinding
import team.dahaeng.android.domain.community.model.schedule.Schedule
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class ModifyScheduleActivity : BaseActivity<ActivityModifyScheduleBinding, MainViewModel>(
    R.layout.activity_modify_schedule
) {

    override val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.schedule = intent.getSerializableExtra("schedule") as Schedule
        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_theme_array,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.snTransportation.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_transportation_array,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.snAccommodation.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_accomodation_array,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.tvScheduledate.setOnClickListener {
            showDatePicker()
        }
        binding.btnComplete.setOnClickListener {
            // Todo : Create new schedule -> changeSchedule
            val schedule = Schedule(
                title = binding.etTitle.text.toString(),
            )

//            schedule.period = getPeriod(binding.tvScheduledate.text.toString())
            //     vm.changeSchedule(schedule, binding.schedule as Schedule)
            vm.importSchedule(DataStore.me.id)
            finish()
        }
    }

    private fun showDatePicker() {
        val dateRangePicker = MaterialDatePicker.Builder.dateRangePicker().apply {
            setTitleText("기간을 선택하세요")
            setSelection(
                Pair(
                    MaterialDatePicker.thisMonthInUtcMilliseconds(),
                    MaterialDatePicker.todayInUtcMilliseconds()
                )
            )
        }.build()
        dateRangePicker.apply {
            show(supportFragmentManager, "date_picker")
            addOnNegativeButtonClickListener { dateRangePicker.dismiss() }
            addOnPositiveButtonClickListener {
                val startDate = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(it.first)
                val endDate = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(it.second)
                binding.tvScheduledate.setText(startDate + " ~ " + endDate)
            }
        }
    }
}