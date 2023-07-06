package com.example.composetestapp.codelab2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.unit.dp
import com.example.composetestapp.R


internal class Composables {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SearchBar(
        modifier: Modifier = Modifier
    ) {
        // 얘도 Composable function이다.
        TextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Search, "search Image") },
            colors = TextFieldDefaults.textFieldColors( // 기본속성에서 일부만 베껴서 적용된다.
                containerColor = MaterialTheme.colorScheme.surface
            ),
            modifier = modifier // view constraint 맞춰주던 것 처럼 사용하면 된다.
                .fillMaxWidth()
                .heightIn(min = 56.dp), // [Recommended!] 최소 크기만 정해주면 글자 크기가 커질 때도 대응할 수 잇다.
            placeholder = { Text("place holder text") },
        )

    }

//    @Composable
//    @Preview()
//    fun ImageList(
//        modifier: Modifier = Modifier
//    ) {
//        LazyRow(content = )
//    }

    @Composable
    fun AlignYourBodyElement(
        modifier: Modifier = Modifier,
        imageId: Int = R.drawable.ic_launcher_background,
        textId: Int = R.string.app_name,
    ) {
        /*
        * 조건
        * 1. 사진 지름은 88dp : modifier.size(88.dp)
        * 2. 사진이랑 텍스트 baseline의 간격은 24dp
        * 3. 텍스트 baseline 밑에는 8dp의 여백 필요 : modifier.paddingFromBaseline
        * 4. text는 H3 스타일 : style = MaterialTheme.typography.headlineSmall,
        * 5. 중앙 정렬 : 부모 컨테이너에 horizontalAlignment 속성 적용
        * */
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop, //이미지 배울은 Fit(확대 안함), FillBounds, Crop(화면에 맞춤)중 선택가능
                modifier = modifier
                    .clip(CircleShape)
                    .size(88.dp),
            )
            Text(
                text = stringResource(textId),
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier
                    .paddingFromBaseline(
                        top = 24.dp, bottom = 8.dp
                    )
                    .align(Alignment.Start)
            )
        }
    }

    @Composable
    fun FavoriteCollectionCard(
        modifier: Modifier = Modifier, // modifier는 first optional parameter가 되어야한다.
        imageId: Int = R.drawable.ic_launcher_background,
        textId: Int = R.string.app_name,
    ) {
        /*
        * 조건
        * 1. 텍스트는 h3
        * 2. rounded corner : Surface의 shape param 이용
        * 3. 뒷 배경과 구분되는 하얀 색 :
        * 4. 이미지는 작은 직사각형으로 크롭 : Image의 contentScale param 이용
        * */
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.small,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.width(192.dp)
            ) {
                Image(
                    modifier = modifier.size(56.dp),
                    painter = painterResource(id = imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Text(
                    text = stringResource(id = textId),
                )
            }
        }
    }

    val alignYourBodyData = listOf<Pair<Int, Int>>(
        R.drawable.ic_launcher_background to R.string.app_name,
        R.drawable.ic_launcher_background to R.string.app_name,
        R.drawable.ic_launcher_background to R.string.app_name,
    )

    @Composable
    fun AlignYourBodyRow(
        modifier: Modifier = Modifier,
    ) {
        /*
        * 조건
        * 1. 아이템간 거리는 8dp -> arrangement 개념 이해 필요.
        * 2. 리사이클러뷰 처럼 여러개가 동적으로 떠야함
        *
        * Q. modifier를 수정하는 것과 속성을 정의하는 것의 차이는 의미차이뿐인가?
        * : 뭔가 modifier는 하위 컴포저블들에게도 영향을 미치고싶을 때 하는 것 같다.
        * */
        LazyRow(
            modifier = modifier.padding(PaddingValues(8.dp)),
            horizontalArrangement = Arrangement.spacedBy(18.dp),
        ) {
            items(alignYourBodyData.size) { item ->
                val info = alignYourBodyData[item]
                AlignYourBodyElement(
                    modifier,
                    info.first,
                    info.second
                ) // Scope 안에서 composable을 호출하는 식으로 작동.
            }
        }
    }

    val favoriteCollectionsData = listOf<Pair<Int, Int>>(
        R.drawable.ic_launcher_background to R.string.app_name,
        R.drawable.ic_launcher_background to R.string.app_name,
        R.drawable.ic_launcher_background to R.string.app_name,
    )

    @Composable
    fun FavoriteCollectionsGrid(
        modifier: Modifier = Modifier
    ) {
        /*
        * 조건
        * 1. wrap_content 되도록 설정하기. 기본 설정에서는 다 화면 크기만큼 차지한다.
        * */
        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.height(120.dp),
        ) {
            items(favoriteCollectionsData.size) { i ->
                val item = favoriteCollectionsData[i]
                FavoriteCollectionCard(modifier.height(56.dp), item.first, item.second)
            }
        }
    }

    @Composable
    fun SootheBottomNavigation(modifier: Modifier = Modifier) {
        // M3 이전으로 인해 잘 안됨...
//        BottomNavigation(modifier) {
//            BottomNavigationItem(
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.Spa,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    Text(stringResource(R.string.bottom_navigation_home))
//                },
//                selected = true,
//                onClick = {}
//            )
//            BottomNavigationItem(
//                icon = {
//                    Icon(
//                        imageVector = Icons.Default.AccountCircle,
//                        contentDescription = null
//                    )
//                },
//                label = {
//                    Text(stringResource(R.string.bottom_navigation_profile))
//                },
//                selected = false,
//                onClick = {}
//            )
//        }
    }

}