/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [WriteViewModel.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.wirte

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.usecase.UploadImageToStorageUseCase
import team.dahaeng.android.domain.community.usecase.UploadPostToStorageUseCase
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val uploadImageToStorageUseCase: UploadImageToStorageUseCase,
    private val uploadPostToStorageUseCase: UploadPostToStorageUseCase
) : BaseViewModel<BaseEvent>() {
    private val userName = "210202" // kakao userName
    private val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.KOREA).format(Date())
    private val imgFileName = timeStamp + "_"+ userName + "_.png"

    private val _postImage = MutableLiveData<Uri>()
    val postImage: LiveData<Uri> get() = _postImage

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> get() = _post

    fun uploadPost() = viewModelScope.launch {
        uploadPostToStorageUseCase.invoke(getPost()!!)
    }

    fun uploadImage(uri: Uri) = viewModelScope.launch {

        Log.i("uploadImage", imgFileName)
        uploadImageToStorageUseCase.invoke(uri, imgFileName)
    }

    fun setPost(title :String, content : String, expense :String, period : String, tagTheme : String) {
        Log.i("setPost", imgFileName)
        _post.value = Post(imgFileName, title,content,expense, period, tagTheme, userName)
    }

    fun getPost() : Post? {
        return _post.value
    }

    fun setPostImage(uri: Uri) {
        _postImage.value = uri
    }

    fun getPostImage(): Uri? {
        return _postImage.value
    }
}