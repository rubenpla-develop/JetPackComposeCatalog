package com.rubenpla.jetpackcomposecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyBasicDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        AlertDialog(title = { Text(text = "Dialog Title ") },
            text = { Text(text = "Description body") },
            confirmButton = {
                TextButton(onClick = {
                    onConfirm()
                }
                ) {
                    Text(text = "Accept")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    onDismiss()
                }) {
                    Text(text = "Decline")
                }
            },
            onDismissRequest = {
                onDismiss()
            })
    }

}

@Composable
fun MyCustomDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false
            )
        ) {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(24.dp)
            ) {
                Text(text = "Custom Dialog Text")
            }
        }
    }

}