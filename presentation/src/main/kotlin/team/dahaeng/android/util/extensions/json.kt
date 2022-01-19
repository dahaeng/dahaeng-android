/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [json.kt] created by Ji Sungbin on 22. 1. 18. 오후 6:57
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.util.extensions

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

@PublishedApi
internal val mapper by lazy {
    ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .registerKotlinModule()
}

inline fun <reified T> String.toModel(): T = mapper.readValue(this, T::class.java)
    ?: throw Exception("문자열을 json 모델로 바꾸는데 오류가 발생했어요.\n\n($this)")

fun Any.toJsonString() = mapper.writeValueAsString(this)
    ?: throw Exception("json 모델을 문자열로 바꾸는데 오류가 발생했어요.\n\n($this)")
