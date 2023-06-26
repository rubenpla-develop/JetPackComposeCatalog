package com.rubenpla.jetpackcomposecatalog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MyConfirmationDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (showDialog) {
        Dialog(onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false, decorFitsSystemWindows = true)
        ) {
            var status by remember {
                mutableStateOf("")
            }
            
            Column(
                modifier = Modifier
                    .background(Color.White)
                   // .padding(24.dp)
                    .fillMaxWidth()
            ) {
                TitleDialog(text = "Phone ringtone", Modifier.padding(top = 12.dp, start = 12.dp, bottom = 12.dp))
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 2.dp), color = Color.DarkGray, thickness = 1.dp)
                MyRadioButtonList(name = status, onItemSelected = { status = it } )
                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 2.dp), color = Color.DarkGray, thickness = 1.dp)
                Row(Modifier.align(Alignment.End)) {
                    TextButton(onClick = { onDismiss() }) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { onConfirm() }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

@Composable
fun TitleDialog(text : String, modifier : Modifier = Modifier.padding(bottom = 12.dp)) {
    Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 20.sp,
    modifier = modifier)
    
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