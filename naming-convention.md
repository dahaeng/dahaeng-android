# 다행 네이밍 컨벤션

## 리소스

> 스네이크 표기법 사용

#### strings.xml

**> 타입_사용구역_주제_설명**

> activity_setting_notification_access_permission (주제: notification)
> fragment_setting_toast_storage_permission_granted (주제: toast)

###### 사용구역

1. dialog: 다이얼로그 리소스
2. activity: 엑티비티 리소스
3. fragment: 프레그맨트 리소스
4. bottomsheet: 바텀시트 리소스

#### drawable

**> 사용용도_타입_설명_사이즈**

> bg_baseline_gradient_500

###### 사용용도

1. bg: 배경사진 용도
2. ic: 아이콘 용도

###### 타입

1. rounded: 원형
2. baseline: 기본값

###### 사이즈

사이즈는 dp기준으로 하며 끝에 dp 표기는 생략함

#### colors.xml

**> 색이름_강도(선택사항)**

> red
>
> blue_200
>
> blue_400
>
> blue_600

#### themes.xml, View ID (XML)

**> 타입_설명 (타입은 약어 사용)**

> tv_header
>
> tv_title
>
> btn_register

## 클래스명(파일명)

> 파스칼 표기법 사용

**> 이름_사용목적**

> MainActivity
>
> SettingFragment
>
> LoginBottomSheet

###### 사용목적

1. dialog: 다이얼로그
2. activity: 엑티비티
3. fragment: 프레그맨트
4. bottomsheet: 바텀시트

#### 만약 `extension` 클래스일 경우

**> 해당 `extension`의 `this` 대상으로 파일명을 작성**

> TextView.kt
>
> Int.kt
>
> String.kt

#### 만약 해당 `extension`의 `this` 대상이 `Unit`일 경우

**> 해당 `extension` 함수들의 공통 목적으로 파일명을 전체 대문자로 작성**

> UI.kt
