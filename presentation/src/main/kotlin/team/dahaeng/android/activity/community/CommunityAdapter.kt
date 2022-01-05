package team.dahaeng.android.activity.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import team.dahaeng.android.databinding.PostItemBinding
import team.dahaeng.android.domain.model.Post

class CommunityAdapter : RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {

    private var postList = listOf<Post>()

    fun setPostList(list : List<Post>){
        postList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
        val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        holder.titleTextView.text = postList[position].title
        holder.contentTextView.text = postList[position].content
        holder.idTextView.text = postList[position].id
    }

    override fun getItemCount(): Int = postList.size

    class CommunityViewHolder(private val binding: PostItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var titleTextView = binding.textviewPostTitle
        var idTextView = binding.textviewPostId
        var contentTextView = binding.textviewPostContent

//        fun bind(){
//                  Todo: item DataBinding
//        }
    }
}