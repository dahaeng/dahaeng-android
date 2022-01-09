/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:12
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import android.net.Uri
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.domain.community.usecase.ImportFirebaseStorageUseCase
import team.dahaeng.android.domain.community.usecase.UploadFirebaseStorageUseCase
import team.dahaeng.android.activity.community.model.ListLiveData
import team.dahaeng.android.domain.community.model.Post
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val uploadFirebaseStorageUseCase: UploadFirebaseStorageUseCase,
    private val importFirebaseStorageUseCase: ImportFirebaseStorageUseCase
) :
    BaseViewModel<BaseEvent>() {

    val postList = ListLiveData<Post>()

    fun uploadImage(uri: Uri) = viewModelScope.launch {
        uploadFirebaseStorageUseCase(uri)
    }

    fun importPostList() = viewModelScope.launch {
       postList.addAll(importFirebaseStorageUseCase.invoke())
    }


}
