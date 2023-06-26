package com.rubenpla.jetpackcomposecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

@Composable
fun MyCustomAdvancedDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismiss() }
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(text = "Set backup account")
                AccountItem(email = "mail1@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "mail2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Add new account", drawable = R.drawable.add)
            }
        }
    }

}

@Composable
fun TitleDialog(text : String) {
    Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 20.sp,
    modifier = Modifier.padding(bottom = 12.dp))
    
}

@Composable
fun AccountItem(email : String, @DrawableRes drawable : Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(painter = painterResource(id = drawable), contentDescription = "avatar",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(40.dp)
            .clip(CircleShape)
            )
        
        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}