package com.binar.challange8.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.R
import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.binar.unsplash.data.model.GetResponseItem


@ExperimentalCoilApi
@Composable
fun PhotoItem(result: GetResponseItem,onItemClick:(GetResponseItem)-> Unit) {

    Card(
        modifier = Modifier

            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(8.dp), elevation = 8.dp

    ) {
        Image(
            painter = rememberImagePainter(
                data = result.urls?.regular,

                builder = {
                    scale(Scale.FILL)
                    placeholder(R.drawable.ic_popup_sync)

                }
            ),
            contentDescription = result.id,
            modifier = Modifier
                .clickable {onItemClick(result)}
                .fillMaxSize()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop

        )
    }
}