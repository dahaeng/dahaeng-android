package team.dahaeng.android.activity.community

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding
import team.dahaeng.android.domain.model.Post
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CommunityActivity : BaseActivity<ActivityCommunityBinding, CommunityViewModel>(
    R.layout.activity_community
) {
    private var image = 0
    private var uriPhoto: Uri? = null
    private val storage by lazy { Firebase.storage } // 반복되는 storage 변수 선언 대신 최상단에 한 번만 선언

    override val vm: CommunityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerviewCommunity.adapter = CommunityAdapter()

        // loadFireStore()

        binding.buttonUploadimage.setOnClickListener {
            val imagePickIntent = Intent(Intent.ACTION_PICK)
            imagePickIntent.type = "image/*"
            startActivityForResult(imagePickIntent, image) // Deprecated!
        }
        binding.buttonLoadimage.setOnClickListener {
            loadFirebaseStorage()
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

    private fun loadFirebaseStorage() {
        // TODO: 이미지 로드 -> TedImagePicker 등등 이미지 피커 라이브러리 사용
        var storageRef = storage.reference
        storageRef.child("image/IMAGE_20220104_103538_.png").downloadUrl.addOnSuccessListener { Uri ->
            Glide.with(this)
                .load(Uri)
                .into(binding.imageviewCommunity)
        }

    }

    private fun uploadFirebaseStorage() {
        val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA).format(Date())
        val imgFileName = "IMAGE_" + timeStamp + "_.png"
        val storageRef = storage.reference.child("image").child(imgFileName)
        storageRef.putFile(uriPhoto!!).addOnSuccessListener {
            Log.i("UPLOAD FIREBASE", "SUCCESS")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == image) {
            if (resultCode == Activity.RESULT_OK) {
                uriPhoto = data?.data
                binding.imageviewCommunity.setImageURI(uriPhoto)
                uploadFirebaseStorage()
            }
        }
    }
}
