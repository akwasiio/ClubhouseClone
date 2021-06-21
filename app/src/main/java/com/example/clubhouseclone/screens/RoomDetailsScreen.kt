package com.example.clubhouseclone.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MicOff
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.clubhouseclone.R
import com.example.clubhouseclone.components.ProfileImage
import com.example.clubhouseclone.ui.theme.Jaguar
import com.example.clubhouseclone.ui.theme.MemojiColors
import com.example.clubhouseclone.ui.theme.Purple

val images = listOf(
    R.drawable.first,
    R.drawable.second,
    R.drawable.third,
    R.drawable.fourth,
    R.drawable.fifth,
    R.drawable.sixth,
    R.drawable.seventh,
    R.drawable.eight,
    R.drawable.ninth,
    R.drawable.tenth,
    R.drawable.eleventh,
    R.drawable.twelvth
)

@ExperimentalFoundationApi
@Composable
fun RoomDetailsScreen(navigateUp: () -> Unit) {
    Scaffold(topBar = { TopBar(navigateUp = navigateUp) }, bottomBar = { BottomAppBar() }) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
            modifier = Modifier.fillMaxSize(),
        ) {

            items(30) { index ->
                Column(modifier = Modifier.wrapContentSize()) {
                    Speaker(
                        image = images[images.indices.random()],
                        showMic = index < 6,
                        isModerator = index < 3
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun TopBar(navigateUp: () -> Unit) {
    TopAppBar(
        title = { Text("Building with Compose") },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 0.dp,
        navigationIcon = {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = "Back to previous screen",
                modifier = Modifier.clickable(onClick = navigateUp)
            )
        },)
}

@Composable
fun BottomAppBar() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Purple,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            )
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Divider(
            thickness = 4.dp,
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(5.dp), color = Color.White.copy(alpha = 1f),
                )
                .width(50.dp)
                .align(alignment = Alignment.CenterHorizontally),
        )
        InputFieldLayout()
        LeaveQuietlyLayout()
    }
}


@Composable
fun InputFieldLayout() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        TextField(
            "",
            onValueChange = {},
            shape = RoundedCornerShape(30.dp),
            placeholder = {
                Text(
                    "Type a thought here...",
                    style = MaterialTheme.typography.body1.copy(color = Color.White)
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
        Icon(
            Icons.Default.Send,
            contentDescription = null,
            tint = Purple,
            modifier = Modifier
                .background(color = Color.White, shape = CircleShape)
                .padding(10.dp)
        )
    }
}

@Composable
private fun LeaveQuietlyLayout() {
    Box(
        modifier = Modifier.background(
            MaterialTheme.colors.background,
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 24.dp)
                .fillMaxWidth()
        ) {
            LeaveQuietlyButton()
            RaiseHandLayout()
        }
    }
}

@Composable
private fun LeaveQuietlyButton() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = if (isSystemInDarkTheme()) Color(0xFF2a2b29) else Color(0xFFebf0fd),
                shape = RoundedCornerShape(30.dp)
            )
            .padding(16.dp)
    ) {
        Text("✌🏽 Leave quietly", style = MaterialTheme.typography.body1.copy(color = Purple))
    }
}

@Composable
private fun RaiseHandLayout() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "✋🏾",
            modifier = Modifier
                .background(
                    color = if (isSystemInDarkTheme()) Color(0xFF2a2b29) else Color(
                        0xFFebf0fd
                    ), shape = CircleShape
                )
                .padding(8.dp)
        )

        ProfileImage(
            image = R.drawable.fifth,
            cornerRadius = 20.dp,
            backgroundColor = if (isSystemInDarkTheme()) Color(0xFF2a2b29) else Color(0xFFebf0fd)
        )
    }
}

@Composable
fun Speaker(image: Int, showMic: Boolean = false, isModerator: Boolean = false) {
    Column(modifier = Modifier.wrapContentSize()) {
        ProfileImageWithIcons(showMic = showMic, image = image)
        Spacer(Modifier.height(4.dp))
        ProfileName(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isModerator = isModerator
        )
    }
}

@Composable
fun ProfileImageWithIcons(image: Int, showMic: Boolean) {
    Box {
        ProfileImage(
            image = image,
            backgroundColor = MemojiColors.color,
            size = 80.dp,
            cornerRadius = 40.dp
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier

                .align(Alignment.BottomStart)
                .offset(x = (-5).dp)
        ) {
            Text(
                text = "🎉",
                modifier = Modifier
                    .background(
                        color = if (isSystemInDarkTheme()) Jaguar else Color.White,
                        shape = CircleShape
                    )
                    .padding(2.dp)
            )
        }

        if (showMic) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.BottomEnd)
                    .offset(x = 5.dp)
            ) {
                Icon(
                    Icons.Default.MicOff, contentDescription = null, modifier =
                    Modifier
                        .background(
                            color = if (isSystemInDarkTheme()) Jaguar else Color.White,
                            shape = CircleShape
                        )
                        .padding(2.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileName(isModerator: Boolean = false, modifier: Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        if (isModerator) {
            Text(
                "✱",
                color = Color.White,
                modifier = Modifier
                    .background(
                        color = Purple,
                        shape = CircleShape
                    )
                    .size(25.dp),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.width(5.dp))

        }
        Text(
            "Ruth",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.W500)
        )
    }
}


