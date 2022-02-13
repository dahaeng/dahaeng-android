package team.dahaeng.android.activity.main.fragment.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.LayoutScheduleBinding
import team.dahaeng.android.domain.community.model.schedule.Schedule

class ScheduleAdapter(private val onMoreClick: (View, Schedule) -> Unit) :
    ListAdapter<Schedule, ScheduleAdapter.ViewHolder>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutScheduleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, onMoreClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: LayoutScheduleBinding,
        private val onMoreClick: (View, Schedule) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(schedule: Schedule) {
            binding.schedule = schedule
            binding.ivMore.setOnClickListener { view ->
                onMoreClick(view, schedule)
            }
        }
    }

    override fun getItemId(position: Int) = getItem(position).id

    override fun getItemCount() = currentList.count()

    private companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areContentsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem.id == newItem.id

            override fun areItemsTheSame(oldItem: Schedule, newItem: Schedule) =
                oldItem == newItem
        }
    }
}
