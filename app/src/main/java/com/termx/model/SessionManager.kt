package com.termx.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SessionManager {
    private val _sessions = MutableStateFlow<List<Session>>(emptyList())
    val sessions: StateFlow<List<Session>> = _sessions.asStateFlow()

    private var nextId = 0
    private var nextDisplay = 0

    fun createTerminalSession(): Session {
        val session = Session(
            id = nextId++,
            type = SessionType.TERMINAL,
            title = "Terminal $nextId"
        )
        _sessions.value = _sessions.value + session
        return session
    }

    fun createX11Session(): Session {
        val display = nextDisplay++
        val session = Session(
            id = nextId++,
            type = SessionType.X11,
            title = "X11 :$display",
            displayNumber = display
        )
        _sessions.value = _sessions.value + session
        return session
    }

    fun closeSession(id: Int) {
        _sessions.value = _sessions.value.filter { it.id != id }
    }
}
