/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Locate.kt] created by Ji Sungbin on 22. 2. 13. 오후 4:44
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.travel

/**
 * 위치 객체
 *
 * 위도와 경도는 지도에 정확한 마커를 찍기 위해 필요함
 *
 * @property latitude 위도
 * @property longitude 경도
 * @property address 주소 (충청남도 서산시 석림동 ~~~~)
 */
data class Locate(
    val latitude: Double = Double.NaN,
    val longitude: Double = Double.NaN,
    val address: String = "",
)
