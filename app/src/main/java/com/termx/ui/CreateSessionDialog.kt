package com.termx.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateSessionDialog(
    onDismiss: () -> Unit,
    onCreateTerminal: () -> Unit,
    onCreateX11: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("New Session") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = onCreateTerminal,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("New Terminal")
                }
                Button(
                    onClick = onCreateX11,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("New X11 Display")
                }
            }
        },
        confirmButton = {},
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
