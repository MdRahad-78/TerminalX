package com.termx.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.termx.model.Session
import com.termx.engine.TerminalEngine

@Composable
fun TerminalTab(session: Session) {
    val engine = remember { TerminalEngine() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0D0D0D))
    ) {
        Text(
            text = engine.stringFromJNI(),
            color = Color(0xFF00FF00),
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}
