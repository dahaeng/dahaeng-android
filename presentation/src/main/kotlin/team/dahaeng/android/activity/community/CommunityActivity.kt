/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityActiivity.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding
import team.dahaeng.android.domain.community.model.Post

@AndroidEntryPoint
class CommunityActivity : BaseActivity<ActivityCommunityBinding, CommunityViewModel>(
    R.layout.activity_community
) {

    override val vm: CommunityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerviewCommunity.adapter = CommunityAdapter()

        loadFireStore()

        val result =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                vm.uploadImage(result.data?.data!!) // registerForActivityResult는 미리 생성하고 실행해야함
            }



    }

    // TODO: 비즈니스 로직은 뷰모델에 들어가야 해요
    private fun loadFireStore() {
        var postList = arrayListOf<Post>()
        Firebase.firestore.collection("test0103")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
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

    /*private fun loadFirebaseStorage() {
        // TODO: 이미지 로드 -> TedImagePicker 등등 이미지 피커 라이브러리 사용
            var storageRef = storage.reference
        storageRef.child("image/IMAGE_20220104_103538_.png").downloadUrl.addOnSuccessListener { Uri ->
            Glide.with(this)
                .load(Uri)
                .into(binding.imageviewCommunity)
        }

    }*/

}
