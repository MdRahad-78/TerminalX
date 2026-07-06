package com.termx.model

enum class SessionType {
    TERMINAL,
    X11
}

data class Session(
    val id: Int,
    val type: SessionType,
    val title: String,
    val displayNumber: Int = 0
)
