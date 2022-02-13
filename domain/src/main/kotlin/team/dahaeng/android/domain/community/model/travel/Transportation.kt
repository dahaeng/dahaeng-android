/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Transportation.kt] created by Ji Sungbin on 22. 1. 13. 오후 6:50
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

/**
 * 교통수단 객체
 *
 * value class 로 하게 되면 Firestore 에서 object 변환할 때 값 주입을 못하게 됨
 *
 * @property name 교통수단 이름
 * @property description 교통수단에 대해 자유롭게 추가 설명 기제할 필드 (버스 번호 등등)
 * @property price 교통수단 금액
 * @property availableTime 교통수단 이용가능 시간대 (자유롭게 쓸 수 있게 하기 위해 String 으로 받음)
 */
data class Transportation(
    val name: String = "",
    val description: String = "",
    val price: Int = 0,
    val availableTime: String = "",
) {
    companion object {
        val Random get() = TransportationList.All.random()
    }
}

@Suppress("FunctionName", "MemberVisibilityCanBePrivate")
object TransportationList {
    val Car = Transportation("자동차")
    val Bus = Transportation("버스")
    val Subway = Transportation("지하철")
    val Plane = Transportation("비행기")
    val Ship = Transportation("배")
    val All = listOf(Car, Bus, Subway, Plane, Ship)

    fun Other(transportation: String) = Transportation(transportation)
}
