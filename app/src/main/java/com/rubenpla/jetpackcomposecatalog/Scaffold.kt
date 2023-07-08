package com.rubenpla.jetpackcomposecatalog

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    //TODO this is necessary in order to show a Snackbar()
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        MyTopAppBar {
            coroutineScope.launch {
                scaffoldState.showSnackbar("$it clicked!")
            }
        }
    },
        snackbarHost = { SnackbarHost(hostState = scaffoldState) }) {
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(onClickAction: (String) -> Unit) {
    //val context = LocalContext.current
    TopAppBar(title = { Text(text = "Toolbar Title", color = Color.White) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.DarkGray,
            titleContentColor = Color.Gray
        ),
        navigationIcon = {
            IconButton(onClick = {
                onClickAction("Back")
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
                onClickAction("Shopping cart")
            }) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "Shopping cart icon",
                    tint = Color.White
                )
            }

            IconButton(onClick = {
                onClickAction("Build Action")
            }) {
                Icon(
                    imageVector = Icons.Filled.Build,
                    contentDescription = "Build Action Icon",
                    tint = Color.White
                )
            }
        })
}