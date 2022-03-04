/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyScheduleActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.util.Pair
import com.google.android.material.datepicker.MaterialDatePicker
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Locale
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityModifyScheduleBinding
import team.dahaeng.android.domain.schedule.model.Schedule
import team.dahaeng.android.domain.schedule.model.travel.wrapper.CourseList
import team.dahaeng.android.domain.schedule.model.travel.Period
import team.dahaeng.android.domain.schedule.model.travel.Theme
import team.dahaeng.android.domain.schedule.model.travel.Travel

@AndroidEntryPoint
class ModifyScheduleActivity : BaseActivity<ActivityModifyScheduleBinding, ModifyScheduleViewModel>(
    R.layout.activity_modify_schedule
) {

    override val vm: ModifyScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.schedule = intent.getSerializableExtra("modifyschedule") as Schedule
        val schedule = binding.schedule
        var changeCourseList = CourseList()
        binding.period = schedule!!.travel.totalPeriod

        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.schedule_theme_list,
            android.R.layout.simple_dropdown_item_1line
        )

        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    changeCourseList =
                        (intent!!.getSerializableExtra("modifycourselistresult") as CourseList)
                }
            }

        binding.rvModifySchedule.run {
            setHasFixedSize(true)
            setItemViewCacheSize(10)
            adapter = ModifyScheduleAdapter(
                onEditClick = { _, courseList ->
                    val intent = Intent(context, ModifyCourseActivity::class.java)
                    intent.putExtra("modifycourselist", courseList)
                    startForResult.launch(intent)
                    courseList.courses = changeCourseList.courses
                }
            ).apply {
                submitList(schedule.travel.courses)
            }
        }
        binding.snTheme.adapter = ArrayAdapter.createFromResource(
            this,
            R.array.schedule_theme_list,
            android.R.layout.simple_dropdown_item_1line
        )
        binding.snTheme.setSelection(getThemePosition(schedule.travel.theme.name))
        binding.tvTotalperiodselect.setOnClickListener {
            showDatePicker()
        }
        binding.btnComplete.setOnClickListener {
            schedule.title = binding.etTitle.text.toString()
            schedule.travel = Travel(
                theme = Theme(
                    binding.snTheme.selectedItem.toString()
                ),
                commonAddress = binding.etCommonaddress.text.toString(),
                totalPeriod = binding.period as Period,
                totalPrice = binding.etTotalprice.text.toString().toInt(),
                courses = (binding.rvModifySchedule.adapter as ModifyScheduleAdapter).currentList
            )

            // Todo : change schedule in firestore
            //  vm.changeSchedule(schedule)
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
                binding.period = Period(endDate.toLong(), startDate.toLong())
            }
        }
    }
}
