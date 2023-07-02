# Compose-Practice
compose practice

컴포즈를 연습하기 위한 레파지토리입니다. </br>
안드로이드 공식 문서를 참고하여 연습.

tutorial [link](https://developer.android.com/courses/jetpack-compose/course)

### 2023 - 06 ~ 2023-07-06까지 첫번째 Compose App 코드랩

1. Compose 시작하기
2. UI 조정
3. 열과 행 만들기
   1. Jetpack Compose 기초
       - 수정자는 빈 수정자가 할당되는 수정자 매개변수 포함이 좋다.
         ```kotlin
            @Composable
            private fun MyApp(modifier: Modifier = Modifier)
         ```
   2. weight 값이 밀어내는 효과와 사용 가능한 모든 공간을 다 채움, fillMaxWidth 수정자와 중복.

4. Compose에서의 상태
   1. remember 사용, 리액트의 remember와 한 번 비교해보기.
5. 상태 호이스팅
   1. 상위 변수로 만들어서, 콜백으로 조정하기처럼 느껴졌음.
6. 성능 지연 목록 만들기
   1. RecyclerView로 ViewHolder를 재활용하지 않고, 지연 Col을 이용하여, 표현한다고 함.
   2. Recycle 하지 않는데, RecyclerView 보다 성능이 좋다고 함. 알아보기
7. 상태 유지
   1. rememberSaved 사용할 때, 어떤 식으로 작동하는가.
8. 목록에 애니메이션 적용
9. 앱의 스타일 지정 및 테마 설정
10. 설정 완료.