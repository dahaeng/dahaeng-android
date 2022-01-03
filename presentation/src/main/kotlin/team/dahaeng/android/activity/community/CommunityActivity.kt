package team.dahaeng.android.activity.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding
import team.dahaeng.android.domain.model.Post

class CommunityActivity : BaseActivity<ActivityCommunityBinding>(
    R.layout.activity_community
) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var postList = arrayListOf<Post>()
        val db = FirebaseFirestore.getInstance()
        binding.recyclerviewCommunity.adapter = CommunityAdapter()

        db.collection("test0103")
            .get()
            .addOnSuccessListener { result ->
                for(document in result){
                    val post = Post(
                        document["title"] as String,
                        document["content"] as String,
                        document["id"] as String
                    )
                    postList.add(post)
                }
                (binding.recyclerviewCommunity.adapter as CommunityAdapter).setPostList(postList)

            }
            .addOnFailureListener { exception ->
                Log.i("exception", exception.message.toString())
            }

    }
}