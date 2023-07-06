package com.example.composetestapp.codelab2

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetestapp.R

class Sections {
    private val composables = Composables()

    @Composable
    fun HomeSection(
        @StringRes title: Int,
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit, // slot의 매개변수. trailing lambda로 composable content를 채울 수 있다.
    ) {
        /* 조건
        * 1. Section API로 만들어보기.
        * 2. 첫 글자는 대문자.
        * 3. H2 스타일 적용, 패딩 적용
        * */
        Column(modifier) {
            // 섹션 제목
            Text(
                text = stringResource(title).uppercase(),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                    .padding(horizontal = 16.dp)
            )
            // 섹션 콘텐츠
            content()

        }
    }

    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
    @Composable
    fun HomeSectionPreview(modifier: Modifier = Modifier) {
        HomeSection(
            title = R.string.align_header_text,
            modifier = modifier,
            content = { composables.AlignYourBodyRow() }
        )
    }

}