package com.example.clubhouseclone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.R
import com.example.clubhouseclone.components.LiveRoom
import com.example.clubhouseclone.components.ProfileImage
import com.example.clubhouseclone.components.Topic
import com.example.clubhouseclone.components.UpcomingRoom
import com.example.clubhouseclone.model.Room
import com.example.clubhouseclone.model.RoomStatus
import com.example.clubhouseclone.ui.theme.ClubhouseCloneTheme
import com.example.clubhouseclone.ui.theme.MemojiColors
import com.example.clubhouseclone.ui.theme.Typography

@Composable
fun HomeScreen(onLiveRoomClick: () -> Unit) {
    Scaffold(
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                AppBar()
                Spacer(modifier = Modifier.height(24.dp))
                TopicsRow()
            }
        }, bottomBar = { BottomBar() }
    ) {
        Content(onLiveRoomClick = onLiveRoomClick)
    }
}

@Composable
fun AppBar() {
    TopAppBar(title = { Text(text = "Good morning,\nIsaac") }, actions = {
        Icon(
            Icons.Default.Search,
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.width(10.dp))
        ProfileImage(image = R.drawable.tenth, cornerRadius = 20.dp, backgroundColor = MemojiColors.color)
    }, elevation = 0.dp, backgroundColor = MaterialTheme.colors.background)
}

@Composable
fun BottomBar() {
    val gradient = Brush.verticalGradient(
        colorStops = arrayOf(
            Pair(0f, MaterialTheme.colors.background.copy(alpha = 0f)),
            Pair(0.4f, MaterialTheme.colors.background),
            Pair(1f, MaterialTheme.colors.background),
        )
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(gradient)
            .padding(start = 16.dp, top = 30.dp, end = 16.dp, bottom = 10 .dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconContainer(icon = Icons.Default.CalendarToday)
        StartRoomButton()
        IconContainer(icon = Icons.Outlined.Person)
    }
}

@Composable
fun Content(onLiveRoomClick: () -> Unit) {
    val rooms = listOf(
        Room(
            title = "STARTUP CLUB",
            description = "Pitch your startup ideas to VCs & top entrepreneurs",
            time = "10:00 - 20:00",
            participants = 300,
            speakers = 5,
            status = RoomStatus.LIVE
        ),
        Room(
            title = "STARTUP CLUB",
            description = "Pitch your startup ideas to VCs & top entrepreneurs",
            time = "10:00 - 20:00",
            participants = 300,
            speakers = 5,
            status = RoomStatus.LIVE
        ),
        Room(
            title = "STARTUP CLUB",
            description = "Pitch your startup ideas to VCs & top entrepreneurs",
            time = "10:00 - 20:00",
            participants = 300,
            speakers = 5,
            status = RoomStatus.LIVE
        ),
        Room(
            title = "STARTUP CLUB",
            description = "Pitch your startup ideas to VCs & top entrepreneurs",
            time = "10:00 - 20:00",
            participants = 300,
            speakers = 5,
            status = RoomStatus.LIVE
        ),
        Room(
            title = "Design talks and chill",
            description = "Pitch your startup ideas to VCs & top entrepreneurs",
            time = "10:00 - 20:00",
            participants = 300,
            speakers = 5,
            status = RoomStatus.UPCOMING
        )
    ).sortedBy { it.status }.groupBy { it.status }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        rooms.forEach { (section, rooms) ->
            item {
                Text(text = section.value)
            }

            items(rooms) { room ->
                if (section == RoomStatus.UPCOMING) {
                    UpcomingRoom()
                } else {
                    LiveRoom(
                        title = room.title,
                        description = room.description,
                        speakers = room.speakers,
                        participants = room.participants,
                        profileImages = listOf(
                            R.drawable.eight,
                            R.drawable.fifth,
                            R.drawable.twelvth
                        ),
                        onClick = onLiveRoomClick
                    )
                }
            }
        }

    }
}

@Composable
private fun IconContainer(icon: ImageVector) {
    Box(
        modifier = Modifier
            .background(
                color = if (isSystemInDarkTheme()) Color(0xFF2a2b29) else Color(0xFFebf0fd),
                shape = CircleShape.copy(
                    CornerSize(8.dp)
                )
            )
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier
                .padding(5.dp)
                .size(20.dp)
                .align(alignment = Alignment.Center)
        )
    }
}

@Composable
private fun StartRoomButton() {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp
    ) {
        Row(
            Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Rounded.AddCircle,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.White
            )
            Text("Start room", style = Typography.body1.copy(color = Color.White))
        }
    }
}

@Composable
fun TopicsRow() {
    val topics = listOf(
       "🎨 Design",
        "🕹 Games",
        "🏀 Basketball",
        "🧠 Creators",
        "🎨 Design",
        "🕹 Games",
        "🏀 Basketball",
        "🧠 Creators"
    )
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(topics) { topic ->
            Topic(title = topic, MemojiColors.color)
        }
    }
}



@Preview(device = Devices.PIXEL_3A_XL)
@Composable
fun HomeScreenPreview() {
    ClubhouseCloneTheme {
        HomeScreenPreview()
    }
}