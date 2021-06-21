package com.example.clubhouseclone.ui.theme

import androidx.compose.ui.graphics.Color

val Orange = Color(0xFFf69677)
val Purple = Color(0xFF5d5fee)
val DeepPurple = Color(0xFF3700B3)
val WhiteSmoke = Color(0xFFf8f7fd)
val Gray400 = Color(0xFF0a0a0a)
val Jaguar = Color(0xFF29292b)

val Solitude = Color(0xFFeff0f5)

object MemojiColors {
    private val black = Color(0xFF262626)
    private val amber = Color(0xFFf9d6a1)
    private val white = Color(0xFFe8e8e8)
    private val yellow = Color(0xFFffe9a6)
    private val green = Color(0xFFc3f1c5)
    private val red = Color(0xFFf7c9d4)
    private val blue = Color(0xFFcbe9fc)
    private val purple = Color(0xFFddd2fa)

    val colors: List<Color>
        get() = listOf(black, amber, white, yellow, green, red, blue, purple)

    val color: Color
        get() = colors[(colors.indices).random()]
}