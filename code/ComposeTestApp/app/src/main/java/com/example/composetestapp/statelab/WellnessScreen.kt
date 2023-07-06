package com.example.composetestapp.statelab

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class WellnessScreen {

    @Composable
    @Preview(showSystemUi = true)
    fun WellnessScreen(modifier: Modifier = Modifier) {
        WaterCounter(modifier)
    }

    @Composable
    fun WaterCounter(modifier: Modifier = Modifier) {

        // count를 저장하는 다양한 방법
        // var count = 0 // step1. state로 인식되지 않음
        // val count = mutableStateOf(0) // step2. remember이 없어 Recomposition시 다시 초기화됨
        // val count = remember { mutableStateOf(0) }
        var count by remember { mutableStateOf(0) } // .value 없어도 됨

        Column(modifier = modifier.padding(16.dp)) {
            if (count > 0) {
                var showTask by remember { mutableStateOf(true) }

                if(showTask){
                    Text(
                        text = "You've had ${count} glasses.",
                        modifier = modifier,
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
        onClose: () -> Unit,
        modifier: Modifier = Modifier
    ) {
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

}