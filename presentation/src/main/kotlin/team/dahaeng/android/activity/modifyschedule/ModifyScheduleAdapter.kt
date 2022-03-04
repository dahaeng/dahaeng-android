/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyScheduleAdapter.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutRvModfiyScheduleItemBinding
import team.dahaeng.android.domain.community.model.travel.wrapper.CourseList

class ModifyScheduleAdapter(
    private val onEditClick: (View, CourseList) -> Unit,
) :
    ListAdapter<CourseList, ModifyScheduleAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutRvModfiyScheduleItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding, onEditClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.coursepositionTextview.text = "코스 " + (position + 1)
    }

    class ViewHolder(
        private val binding: LayoutRvModfiyScheduleItemBinding,
        private val onEditClick: (View, CourseList) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        val coursepositionTextview = binding.tvCourse

        fun bind(courseList: CourseList) {
            binding.rvHorizontal.adapter = PlaceAdapter().apply {
                submitList(courseList.courses)
            }
            binding.ibEdit.setOnClickListener { view ->
                onEditClick(view, courseList)
            }
        }
    }

    override fun getItemCount() = currentList.count()

    private companion object {
        val diffUtil = object : DiffUtil.ItemCallback<CourseList>() {
            override fun areContentsTheSame(oldItem: CourseList, newItem: CourseList) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: CourseList, newItem: CourseList) =
                oldItem == newItem
        }
    }
}
