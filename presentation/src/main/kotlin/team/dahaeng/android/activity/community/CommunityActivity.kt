package team.dahaeng.android.activity.community

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.text.SimpleDateFormat
import java.util.Locale
import team.dahaeng.android.R
import team.dahaeng.android.activity.base.BaseActivity
import team.dahaeng.android.databinding.ActivityCommunityBinding
import team.dahaeng.android.domain.model.Post

class CommunityActivity : BaseActivity<ActivityCommunityBinding>(
    R.layout.activity_community
) {

    var image = 0
    var uriPhoto: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerviewCommunity.adapter = CommunityAdapter()

        // loadFireStore()

        binding.buttonCommunityLoadimage.setOnClickListener {
            val imagePickIntent = Intent(Intent.ACTION_PICK)
            imagePickIntent.type = "image/*"
            startActivityForResult(imagePickIntent, image)
        }
    }

    private fun loadFireStore() {
        val db = FirebaseFirestore.getInstance()
        var postList = arrayListOf<Post>()
        db.collection("test0103")
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
        // Todo : 이미지 로드
        val storage = Firebase.storage
        var storageRef = storage.reference.child("image")
    }

    private fun uploadFirebaseStorage() {

        var timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA).format(Date())
        var imgFileName = "IMAGE_" + timeStamp + "_.png"
        val storage = Firebase.storage
        var storageRef = storage.reference.child("image").child(imgFileName)
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
