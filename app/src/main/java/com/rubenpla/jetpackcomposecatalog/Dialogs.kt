package com.rubenpla.jetpackcomposecatalog

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

@Composable
fun myBasicDialog(
    context: Context,
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