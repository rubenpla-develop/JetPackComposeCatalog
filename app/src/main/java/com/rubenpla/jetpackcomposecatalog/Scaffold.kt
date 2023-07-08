package com.rubenpla.jetpackcomposecatalog

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    //TODO this is necessary in order to show a Snackbar()
    val scaffoldState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar {
                coroutineScope.launch {
                    scaffoldState.showSnackbar("$it clicked!")
                }
            }
        },
        snackbarHost = { SnackbarHost(hostState = scaffoldState) },
        bottomBar = { MyBottomNavigationBar() },
        floatingActionButton = { MyFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center
    ) {}
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

@Composable
fun MyBottomNavigationBar() {
    var index by remember {
        mutableStateOf(0)
    }

    NavigationBar(
        containerColor = Color.DarkGray,
        contentColor = Color.White
    ) {
        NavigationBarItem(selected = index == 0,
            onClick = { index = 0 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon",
                    tint = Color.White
                )
            },
            label = { Text(text = "Home", color = Color.White) })

        NavigationBarItem(selected = index == 1,
            onClick = { index = 1 },
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorites Icon",
                    tint = Color.White
                )
            },
            label = { Text(text = "Favorites", color = Color.White) })

        NavigationBarItem(selected = index == 2,
            onClick = { index = 2 },
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Account Icon",
                    tint = Color.White
                )
            },
            label = { Text(text = "Account", color = Color.White) })
    }
}


@Composable
fun MyFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        containerColor = Color.Blue,
        shape = FloatingActionButtonDefaults.extendedFabShape,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 32.dp,
            pressedElevation = 8.dp
        )
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "FAB Icon",
            tint = Color.White
        )
    }
}