package com.example.clubhouseclone.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.ui.theme.ClubhouseCloneTheme
import com.example.clubhouseclone.ui.theme.Orange
import com.example.clubhouseclone.ui.theme.Purple

@Composable
fun UpcomingRoom() {
    Card(
        shape = RoundedCornerShape(15.dp),
        backgroundColor = Purple,
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .padding(horizontal = 16.dp, vertical = 32.dp)
            ) {
                Divider(color = Orange, modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp))
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        "10:00 - 20:00",
                        style = MaterialTheme.typography.body2.copy(color = Color.White.copy(alpha = 0.6f))
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        "Design talks and chill",
                        style = MaterialTheme.typography.h6.copy(Color.White)
                    )
                }
            }

            Icon(
                Icons.Default.ChevronRight,
                contentDescription = "Dropdown arrow icon",
                modifier = Modifier.rotate(90f),
                tint = Color.White
            )
        }
    }
}

@Preview(widthDp = 250)
@Composable
fun UpcomingRoomPreview() {
    ClubhouseCloneTheme {
        UpcomingRoom()
    }
}