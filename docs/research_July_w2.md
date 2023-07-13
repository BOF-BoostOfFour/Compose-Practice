# 리컴포지션 최적화-State hoisting과 lambda

## 참고 자료
- [도넛홀 건너뛰기](https://sungbin.land/optimizing-recomposition-in-jetpack-compose-donut-hole-skipping-6baf22f059bb)

### 도넛홀 건너뛰기 요약

<recomposition마다 setContent 자체를 반복하는 코드>
```kotlin
setContent {
    var number by remember { mutableStateOf(0) }
    println("setContent recomposition")
    Text(
        modifier = Modifier.clickable { number++ },
        text = number.toString(),
    ).also { println("Text recomposition") } // 
}
```

<Text만 recomposition되는 코드>
````kotlin
setContent {
    var number by remember { mutableStateOf(0) }
    println("setContent recomposition")
    Button(onClick = { number++ }) {
        Text(
            text = number.toString(),
        ).also { println("Text recomposition") }
    }.also { println("Button recomposition") }
}
```
: Text -> Button / Modifier.clickable -> Button.onClick

Compose의 리컴포지션 시스템의 최적화 메커니즘에 의해 이런 변화가 생긴다.

컴포즈는 Composable을 컴파일 할 때 함수의 위아래로 composer.start/end RestartGroup()을 호출해서 리컴포지션 스코프를 형성한다.
setContent부터 시작해서 가장 하위에 있는 컴포저블까지 층층이 scope를 가지게 되는 것이다.
따라서 state를 가장 하위 컴포저블에서 조작하면 리컴포지션 범위를 줄일 수 있다.

# Get started with state

## 참고 자료
- [CodeLab : Get started with state](https://developer.android.com/codelabs/jetpack-compose-state?hl=ko&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%3Fhl%3Dko%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-state)

### remember는 과연 무엇이었는가
rememeber는 컴포지션에 객체를 저장하고, remember가 호출되는 소스 위치가 리컴포지션 중에 다시 호출되지 않는다면 객체를 삭제하는 역할을 한다.


