/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ModifyCourseAdapter.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.modifyschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutModifyCourseBinding
import team.dahaeng.android.domain.community.model.travel.Course
import java.util.*

class ModifyCourseAdapter :
    ListAdapter<Course, ModifyCourseAdapter.ViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutModifyCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        // TODO: imageview glide
        // TODO: buttons image set
        // TODO: buttons onclickListener

    }

    fun swapItem(fromPos: Int, toPos: Int) {
        val list = currentList.toMutableList()
        Collections.swap(list, fromPos, toPos)
        submitList(list)
    }

    fun removeItem(position: Int) {
        val list = currentList.toMutableList()
        list.removeAt(position)
        submitList(list)
    }

    class ViewHolder(
        private val binding: LayoutModifyCourseBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(course: Course) {
            binding.course = course
        }
    }

    private companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Course>() {
            override fun areContentsTheSame(oldItem: Course, newItem: Course) =
                oldItem == newItem

            override fun areItemsTheSame(oldItem: Course, newItem: Course) =
                oldItem == newItem
        }
    }
}