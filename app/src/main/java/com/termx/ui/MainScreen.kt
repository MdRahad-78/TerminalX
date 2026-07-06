package com.termx.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.termx.model.SessionManager
import com.termx.model.SessionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(sessionManager: SessionManager) {
    var selectedTab by remember { mutableIntStateOf(0) }
    var showCreateDialog by remember { mutableStateOf(false) }

    val tabs = sessionManager.sessions.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("TerminalX") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1A1A2E),
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showCreateDialog = true },
                containerColor = Color(0xFF0F3460)
            ) {
                Icon(Icons.Default.Add, contentDescription = "New Session")
            }
        },
        bottomBar = {
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color(0xFF1A1A2E),
                contentColor = Color.White
            ) {
                tabs.forEachIndexed { index, session ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Text(
                                text = session.title,
                                color = if (selectedTab == index) Color.Cyan else Color.Gray
                            )
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (tabs.isEmpty()) {
                Text(
                    text = "Press + to create a session",
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Gray
                )
            } else if (selectedTab < tabs.size) {
                val session = tabs[selectedTab]
                when (session.type) {
                    SessionType.TERMINAL -> TerminalTab(session)
                    SessionType.X11 -> X11Tab(session)
                }
            }
        }
    }

    if (showCreateDialog) {
        CreateSessionDialog(
            onDismiss = { showCreateDialog = false },
            onCreateTerminal = {
                sessionManager.createTerminalSession()
                showCreateDialog = false
            },
            onCreateX11 = {
                sessionManager.createX11Session()
                showCreateDialog = false
            }
        )
    }
}
