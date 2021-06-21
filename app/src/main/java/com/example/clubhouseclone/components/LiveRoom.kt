package com.example.clubhouseclone.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.ui.theme.*

@Composable
fun LiveRoom(
    title: String,
    description: String,
    speakers: Int,
    participants: Int,
    profileImages: List<Int>,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = 0.dp,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 20.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = description, style = MaterialTheme.typography.body1.copy(Color.Gray))
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                ParticipantsImages(profileImages)

                RoomMemberCountLayout(speakers, participants)
            }
        }
    }
}

@Composable
fun RoomMemberCountLayout(speakers: Int, participants: Int) {
    Card(
        backgroundColor = if(isSystemInDarkTheme()) Purple.copy(alpha = 0.3f) else Solitude,
        shape = RoundedCornerShape(15.dp),
        elevation = 0.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Text(text = participants.toString())
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                Icons.Default.Mic, contentDescription = null, modifier = Modifier.size(18.dp)
            )
            Text(speakers.toString())
        }
    }
}


@Composable
fun ParticipantsImages(images: List<Int>) {
    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        images.map {
            ProfileImage(image = it, backgroundColor = MemojiColors.color)
        }
    }
}