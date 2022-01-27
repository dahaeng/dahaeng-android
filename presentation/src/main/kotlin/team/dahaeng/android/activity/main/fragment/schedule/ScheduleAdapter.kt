package team.dahaeng.android.activity.main.fragment.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutScheduleBinding
import team.dahaeng.android.domain.schedule.Schedule

class ScheduleAdapter : ListAdapter<Schedule, ScheduleAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: LayoutScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            binding.run {
                this.schedule = schedule
                executePendingBindings()
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem.title == newItem.title

            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem == newItem
        }
    }

}