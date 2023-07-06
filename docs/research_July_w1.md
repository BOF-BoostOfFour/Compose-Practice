# Modifier 시작하기

## 참고 자료
- [Fundamentals of Compose Layouts and Modifiers - MAD Skills](https://youtu.be/xc8nAcVvpxY)
- [Android Developer | Compose Modifier](https://developer.android.com/jetpack/compose/modifiers)
- [Android Developer | Compose Layout](https://developer.android.com/jetpack/compose/layouts/material)

## Modifier의 유용한 메서드

### 크기 수정
- default
아무 옵션도 넣지 않으면 View의 wrap_content처럼 자식 컴포저블을 감싸는 크기로 설정된다.

- wrapContentSize/Height/Width()


- fillMaxSize/Height/Width()
컴포저블을 화면 크기에 맞추어 줌. 폴더블의 경우 한쪽 창에만 맞게 크기를 키움.


### 상대적인 위치
- align()
내 부모 레이아웃에 대해 내가 어느 위치에 있도록 할 건지 결정할 때 사용한다.

### 크기
- width()/height()/size()
Composable의 크기를 dp로 정의하고 싶을 때 사용한다.

- weight()
부모 레이아웃 내의 다른 elements에 대해 상대적인 크기를 가지게 하고 싶을 때 사용한다.
만약 다른 element들의 크기가 절대적인 dp 값으로 설정되어 있다면 그곳부터 채우고, weight를 가진 자식들끼리 남은 자리를 나눠 갖는다.


## Compose Layout

### [Arrangement vs Alignment](https://developer.android.com/reference/kotlin/androidx/compose/foundation/layout/Arrangement)
Arrangement가 main axis, alignment가 cross axis에 대한 속성을 정의한다.
이 용어는 다양한 Composable 함수의 parameter 이름에 활용되기 때문에 기억하면 좋다.
Row에서 horizontalArrangement라는 parameter 이름을 쓰고, Column에서는 verticalArrangement라는 이름을 쓴다.
그리고 Layout 내에서 element의 상대적인 위치를 결정할 때 쓰는 Modifier.align()도 이 용어를 쓴다.