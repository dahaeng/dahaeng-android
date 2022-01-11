/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [CommunityViewModel.kt] created by Ji Sungbin on 22. 1. 5. 오후 4:12
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import team.dahaeng.android.activity.base.BaseEvent
import team.dahaeng.android.activity.base.BaseViewModel
import team.dahaeng.android.activity.community.model.ListLiveData
import team.dahaeng.android.domain.community.model.Post
import team.dahaeng.android.domain.community.usecase.ImportFirebaseStorageUseCase
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val importFirebaseStorageUseCase: ImportFirebaseStorageUseCase
) : BaseViewModel<BaseEvent>() {

    val postList = ListLiveData<Post>()

    fun importPostList() = viewModelScope.launch {
        postList.addAll(importFirebaseStorageUseCase.invoke())
    }

    fun importPostImages() = viewModelScope.launch{

    }

}
