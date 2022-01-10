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
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding

@AndroidEntryPoint
class CommunityActivity : BaseActivity<ActivityCommunityBinding, CommunityViewModel>(
    R.layout.activity_community
) {

    override val vm: CommunityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.rvCommunity.adapter = CommunityAdapter()
        vm.importPostList()
        val result =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.data?.data != null) {
                    vm.uploadImage(result.data?.data!!) // registerForActivityResult는 미리 생성하고 실행해야함
                }
            }

//        binding.btnUploadimage.setOnClickListener {
//            val imagePickIntent = Intent(Intent.ACTION_PICK)
//            imagePickIntent.type = "image/*"
//            result.launch(imagePickIntent)
//        }
        vm.postList.observe(this, { postList ->
            if (postList.isNotEmpty()) {
                (binding.rvCommunity.adapter as CommunityAdapter).submitList(postList)
            }
        })
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
