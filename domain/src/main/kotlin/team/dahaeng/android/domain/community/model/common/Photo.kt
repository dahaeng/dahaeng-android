/*
 * Dahaeng © 2022 Ji Sungbin, 210202. all rights reserved.
 * Dahaeng license is under the MIT.
 *
 * [Photo.kt] created by Ji Sungbin on 22. 2. 13. 오후 4:08
 *
 * Please see: https://github.com/dahaeng/dahaeng-android/blob/main/LICENSE.
 */

package team.dahaeng.android.domain.community.model.common

import android.graphics.Bitmap
import team.dahaeng.android.domain.community.model.travel.Place

/**
 * [Place] 에 들어갈 이미지를 Firestore 에 올리기 위해 필요한 정보들을 담는 객체
 *
 * @property bitmap 이미지 비트맵
 * 갤러리에서 이미지를 가져옴: URI 변환, 카메라에서 이미지를 바로 찍음: Bitmap 변환
 * URI은 비트맵으로 바로 변환할 수 있지만, 카메라에서 찍은 이미지를 URI로 변환하는건
 * 찍은 이미지를 따로 파일에 저장하고 해당 파일의 URI을 가져와야 함
 * TODO: 카메라로 찍은 사진도 URI로 가져오기
 * TODO: 비트맵을 통채로 가지고 있는건 메모리 측면에서 매우 안 좋음
 * @property name Firebase Storage에 저장될 이미지 이름 ({이미지 이름}.jpg 로 저장됨)
 */
data class Photo(val bitmap: Bitmap, val name: String)
