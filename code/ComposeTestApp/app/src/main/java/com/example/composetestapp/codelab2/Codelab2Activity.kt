package com.example.composetestapp.codelab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetestapp.R
import com.example.composetestapp.ui.theme.ComposeTestAppTheme

class Codelab2Activity : ComponentActivity() {
    private val composables = Composables()
    private val sections = Sections()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestAppTheme {
                // A surface container using the 'background' color from the theme
                CodeLab2Screen()
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun CodeLab2Screen(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState()) // lazy loading 하고싶으면 LazyColumn으로 되돌아가기.
                .padding(vertical = 16.dp)
        ) {
            Spacer(Modifier.height(16.dp))
            composables.SearchBar(modifier)
            Spacer(Modifier.height(16.dp))
            sections.HomeSection(
                title = R.string.align_header_text,
                modifier = modifier,
                content = { composables.AlignYourBodyRow() }
            )
            Spacer(Modifier.height(16.dp))
            sections.HomeSection(
                title = R.string.favorite_header_text,
                modifier = modifier,
                content = { composables.FavoriteCollectionsGrid(modifier) }
            )
            composables.SootheBottomNavigation(modifier = modifier)
        }

    }
}