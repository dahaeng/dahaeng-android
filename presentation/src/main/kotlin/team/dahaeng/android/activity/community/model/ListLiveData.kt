/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [ListLiveData.kt] created by 210202
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.activity.community.model

import androidx.lifecycle.MutableLiveData

class ListLiveData<T> : MutableLiveData<List<T>>() {
    private val tempList = mutableListOf<T>()

    init {
        value = tempList
    }

    fun add(item: T) {
        tempList.add(item)
        value = tempList
    }

    fun addAll(items: List<T>) {
        tempList.addAll(items)
        value = tempList
    }

    fun remove(item: T) {
        tempList.remove(item)
        value = tempList
    }

    fun clear() {
        tempList.clear()
        value = tempList
    }

}