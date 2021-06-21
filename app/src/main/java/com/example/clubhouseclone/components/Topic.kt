package com.example.clubhouseclone.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.ui.theme.ClubhouseCloneTheme

@Composable
fun Topic(title: String, backgroundColor: Color) {
    Card(
        shape = RoundedCornerShape(30.dp),
        backgroundColor = if (isSystemInDarkTheme()) backgroundColor.copy(alpha = 0.6f) else backgroundColor,
        elevation = 0.dp
    ) {
        Text(title, modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp))
    }
}

@Preview
@Composable
fun TopicPreview() {
    ClubhouseCloneTheme {
        Topic("\uD83C\uDFC0 Basketball", backgroundColor = Color.Cyan)
    }
}