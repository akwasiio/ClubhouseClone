package com.example.clubhouseclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.R

@Composable
fun ProfileImage(image: Int, size: Dp = 40.dp, cornerRadius: Dp = 16.dp, backgroundColor: Color) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "First memoji",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size)
            .background(backgroundColor, shape = CircleShape.copy(CornerSize(cornerRadius)))
    )

}

@Preview
@Composable
fun ProfileImagePreview() {
    ProfileImage(R.drawable.third, backgroundColor = Color.Black)
}