package com.example.clubhouseclone.model

enum class RoomStatus(val value: String) {
    UPCOMING("Upcoming"), LIVE("Happening now")
}

data class Room(
    val title: String,
    val description: String,
    val time: String,
    val speakers: Int,
    val participants: Int,
    val status: RoomStatus
)
