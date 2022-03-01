/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyCourseActivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityModifyCourseBinding
import team.dahaeng.android.domain.community.model.travel.CourseList

@AndroidEntryPoint
class ModifyCourseActivity : BaseActivity<ActivityModifyCourseBinding, ModifyScheduleViewModel>(
    R.layout.activity_modify_course
) {

    override val vm: ModifyScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val courseList = intent.getSerializableExtra("modifycourselist") as CourseList

        binding.rvModifyCourse.run {

            setHasFixedSize(true)
            setItemViewCacheSize(10)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = ModifyCourseAdapter(
            ).apply {
                submitList(courseList.courses)
            }
            setItemTouchCallback()
        }

        binding.btnComplete.setOnClickListener {
            val intent = Intent(applicationContext, ModifyScheduleActivity::class.java).apply {
                val list =
                    (binding.rvModifyCourse.adapter as ModifyCourseAdapter).currentList.toMutableList()
                courseList.courses = list
                putExtra("modifycourselistresult", courseList)
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun setItemTouchCallback() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPos: Int = viewHolder.absoluteAdapterPosition
                val toPos: Int = target.absoluteAdapterPosition
                (binding.rvModifyCourse.adapter as ModifyCourseAdapter).swapItem(fromPos, toPos)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (binding.rvModifyCourse.adapter as ModifyCourseAdapter).removeItem(viewHolder.layoutPosition)
            }

        }
        ItemTouchHelper(itemTouchCallback).attachToRecyclerView(binding.rvModifyCourse)
    }
}