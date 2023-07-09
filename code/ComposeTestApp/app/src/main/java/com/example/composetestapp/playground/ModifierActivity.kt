package com.example.composetestapp.playground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetestapp.ui.theme.ComposeTestAppTheme

class ModifierActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                // A surface container using the 'background' color from the theme
                MainScreen()
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    private fun MainScreen(modifier: Modifier = Modifier) {
        Row(
            modifier = modifier.fillMaxSize().background(color = Color(0xFF00FFFF))
        ) {
            Text(
                text = "가나다라",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .weight(weight = 1.0F)
            )
        }
    }

    companion object {
        private const val TAG = "ModifierActivity"
    }
}