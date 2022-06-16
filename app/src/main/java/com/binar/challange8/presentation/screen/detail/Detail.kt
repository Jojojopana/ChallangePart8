package com.binar.challange8.presentation.screen


import android.R
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.binar.challange8.presentation.screen.detail.DetailViewModel
import com.binar.challange8.data.local.Favorite.PhotoFavorite

import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DetailScreen(photoId: String? = null) {
    val viewModel = getViewModel<DetailViewModel>()
    viewModel.getDetail(photoId.toString())
    val result = viewModel.detailPhoto().observeAsState()
    val contex = LocalContext.current
    result.value?.let {
        val photoFavorite= PhotoFavorite(
            id = it.id,
            description = it.altDescription.toString(),
            createdAt = it.createdAt,
            urls = it.urls?.regular,
        )
        Column {
            Image(
                painter = rememberImagePainter(data = it.urls?.regular,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.ic_popup_sync)
                    }),
                contentDescription = it.id,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)

            )
            Row(modifier = Modifier.wrapContentWidth()) {

            }
            Spacer(modifier = Modifier.padding(top = 4.dp))

            Button(
                onClick = { viewModel.addFavorite(photoFavorite)
                    Toast.makeText(contex,"Jadi Favorite",Toast.LENGTH_LONG).show()}
            ) {
                Text(text = "Favorite")
            }
        }


    }

}

@Composable
@Preview
fun SettingsScreenPreview() {
    DetailScreen("")
}
