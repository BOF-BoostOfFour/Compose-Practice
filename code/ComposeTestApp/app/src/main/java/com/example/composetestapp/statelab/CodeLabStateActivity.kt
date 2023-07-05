package com.example.composetestapp.statelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetestapp.ui.theme.ComposeTestAppTheme

class CodeLabStateActivity: ComponentActivity() {
    private val viewModel: CodeLabStateViewModel by viewModels()
    private val view = WellnessScreen()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ComposeTestAppTheme {
                Surface(modifier = Modifier) {
                    view.WellnessScreen()
                }
            }
        }
    }


}