/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyScheduleActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule


import android.content.Intent
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

        binding.schedule = intent.getSerializableExtra("modifyschedule") as Schedule
        val schedule = binding.schedule
        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_theme_array,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.rvModifySchedule.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = ModifyScheduleAdapter(
                onEditClick = { view, courseList ->
                    val intent = Intent(context, ModifyCourseActivity::class.java)
                    intent.putExtra("modifycourselist", courseList)
                    startActivity(intent)
                }
            ).apply {
                submitList(schedule!!.travel.courseLists)
            }
        }
        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.modify_schedule_theme_array,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.snTheme.setSelection(getThemePosition(schedule!!.travel.theme.value))
        binding.tvTotalperiodselect.setOnClickListener {
            showDatePicker()
        }
        binding.btnComplete.setOnClickListener {
            vm.importSchedule(DataStore.me.id)
            finish()
        }
    }

    private fun getThemePosition(theme: String): Int {
        when (theme) {
            "펜션" -> {
                return 0
            }
            "캠핑" -> {
                return 1
            }
            "스포츠" -> {
                return 2
            }
            "힐링" -> {
                return 3
            }
            "바다" -> {
                return 4
            }
            "산" -> {
                return 5
            }
            "음식" -> {
                return 6
            }
            "명소" -> {
                return 7
            }
        }
        return 0
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
                binding.tvTotalperiodselect.text = startDate + "~" + endDate
            }
        }
    }
}