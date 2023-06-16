# Compose-Practice
compose practice

tutorial [link](https://developer.android.com/courses/jetpack-compose/course)

1. Jetpack Compose 기초
    - 수정자는 빈 수정자가 할당되는 수정자 매개변수 포함이 좋다.
      ```kotlin
         @Composable
         private fun MyApp(modifier: Modifier = Modifier)
      ```
2. weight 값이 밀어내는 효과와 사용 가능한 모든 공간을 다 채움, fillMaxWidth 수정자와 중복.