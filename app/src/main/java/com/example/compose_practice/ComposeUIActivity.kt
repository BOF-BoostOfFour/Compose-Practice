package com.example.compose_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_practice.ui.theme.Compose_practiceTheme
import com.example.compose_practice.model.DrawableStringPair

class ComposeUIActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_practiceTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.app_name))
        },
        modifier = modifier
            .fillMaxWidth() // 검색창의 상위 요소의 전체 가로 길이.
            .heightIn(min = 56.dp)  // 컴포저블의 최소 높이 지정.
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    Compose_practiceTheme {
        SearchBar()
    }
}

@Composable
fun AlignYourBodyElement(
    @StringRes text: Int,
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}


@Preview
@Composable
fun AlignYourBodyElementPreview() {
    Compose_practiceTheme {
        AlignYourBodyElement(
            text = R.string.app_name,
            drawable = R.drawable.ic_launcher_background,
            modifier = Modifier.padding(8.dp)
        )
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.show_less,
    R.drawable.ic_launcher_background to R.string.show_more,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name,
    R.drawable.ic_launcher_background to R.string.app_name
).map { DrawableStringPair(it.first, it.second) }

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}

@Preview
@Composable
fun AlignYourBodyElementsPreview() {
    Compose_practiceTheme {
        AlignYourBodyRow()
    }
}

@Composable
fun FavoriteCollectionCard(
    @StringRes text: Int,
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier,
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp)
    ) {
        items(alignYourBodyData) { item ->
            FavoriteCollectionCard(
                item.text,
                item.drawable,
                modifier = Modifier.height(56.dp)
            )
        }
    }
}


@Preview
@Composable
fun FavoriteCollectionCardPreview() {
    Compose_practiceTheme {
        FavoriteCollectionCard(
            text = R.string.app_name,
            drawable = R.drawable.ic_launcher_background,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun FavoriteCollectionCardPreviews() {
    Compose_practiceTheme {
        FavoriteCollectionsGrid()
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    Compose_practiceTheme {
        HomeSection(title = R.string.app_name) {
            AlignYourBodyRow()
        }
    }
}