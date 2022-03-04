/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [extensions.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:34
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.data.util

import com.google.firebase.firestore.DocumentSnapshot

internal inline fun <reified T> DocumentSnapshot.toObjectNonNull(): T = toObject(T::class.java)!!
