package com.rubenpla.jetpackcomposecatalog

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(topBar = { myTopAppBar() }) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myTopAppBar() {

    val context = LocalContext.current
    TopAppBar(title = { Text(text = "Toolbar Title", color = Color.White) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.Gray
        ),
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "Back button clicked!", Toast.LENGTH_LONG).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Top bar Navigation Icon",
                    tint = Color.White
                )
            }
        },
    actions = {
        IconButton(onClick = {
            Toast.makeText(context, "Shopping Cart clicked!", Toast.LENGTH_LONG).show()
        }) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping cart icon",
                tint = Color.White
            )
        }

        IconButton(onClick = {
            Toast.makeText(context, "Build action clicked!", Toast.LENGTH_LONG).show()

        }) {
            Icon(
                imageVector = Icons.Filled.Build,
                contentDescription = "Build Action Icon",
                tint = Color.White
            )
        }
    })
}