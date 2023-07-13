package com.example.composetestapp.statelab

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class WellnessScreen {

    companion object {
        private const val TAG = "WellnessScreen"
    }

    @Composable
    @Preview(showSystemUi = true)
    fun WellnessScreen(modifier: Modifier = Modifier) {
        WaterCounter(modifier)
    }

    // 내부에 state를 가지고 있으므로 Stateful composable이다.
    @Composable
    fun WaterCounter(modifier: Modifier = Modifier) {

        // count를 저장하는 다양한 방법
        // var count = 0 // step1. state로 인식되지 않음
        // val count = mutableStateOf(0) // step2. remember이 없어 Recomposition시 다시 초기화됨
        // val count = remember { mutableStateOf(0) }
        var count by rememberSaveable { mutableStateOf(0) } // .value 없어도 됨

        Column(modifier = modifier.padding(16.dp)) {
            if (count > 0) {
                var showTask by rememberSaveable { mutableStateOf(true) } // config change에도 상태를 유지
                if (showTask) {
                    Text(
                        text = "You've had ${count} glasses.",
                        modifier = modifier,
                    )
                    WellnessTaskItem(
                        taskName = "15분 걷기",
                        modifier = modifier,
                        onClose = {
                            showTask = false
                        }
                    )

                }
            }
            Button(
                onClick = { count++ },
                modifier.padding(top = 8.dp),
                content = {
                    Text("Add water")
                }
            )
        }
    }

    @Composable
    fun WellnessTaskItem(
        taskName: String,
        onClose: () -> Unit, // 클릭 이벤트를 컴포저블에서 직접 정의하는 대신 람다로 넘긴다!
        modifier: Modifier = Modifier
    ) {
        Log.d(TAG, "WellnessTaskItem re-composited")
        Row(
            modifier = modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = taskName
            )
            IconButton(onClick = onClose) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        }
    }

//    @Composable
//    fun UselessWrapper(
//        modifier: Modifier = Modifier,
//        onClose: () -> Unit
//    ) {
//        Log.d(TAG, "UselessWrapper re-composited")
//        WellnessTaskItem(
//            taskName = "WellnessTaskItem TaskName",
//            onClose = onClose
//        )
//    } // 도넛홀 실험 위해 WellnessTaskItem를 얘로 감싸봤는데 이거 맨날 리컴포지션 된다... visibility가 바뀐다는 차이가 있어서 그런가보다 도넛홀 예시로는 부족했음


}