package com.free.master.chef.recipe.meal.cook.book.view.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.free.master.chef.recipe.meal.cook.book.service.data.CategoryData


@Composable
fun CategoryDetailScreen(categoryData: CategoryData){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "${categoryData.strCategory}", textAlign = TextAlign.Center)

        Image(
            painter = rememberAsyncImagePainter(categoryData.strCategoryThumb),
            contentDescription = categoryData.strCategory,
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
        )

        Text(text = "${categoryData.strCategoryDescription}",
            textAlign = TextAlign.Justify,
            modifier = Modifier.verticalScroll(rememberScrollState())
        )

    }

}