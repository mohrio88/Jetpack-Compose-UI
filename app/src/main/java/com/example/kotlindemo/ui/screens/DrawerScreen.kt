package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DrawerScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val state = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = state,
        topBar = {
            TopAppBar(title = { Text("Jetpack Compose Drawer Example") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {

                            Log.d("close==>", "closed")

                            /*if (drawerState.isClosed)
                                drawerState.open()*/

                            if (state.drawerState.isClosed)
                                state.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
            )
        },
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Text("Drawer Content")
                Spacer(Modifier.height(16.dp))

                Button(onClick = {
                    scope.launch {

                        if (state.drawerState.isOpen)
                            state.drawerState.close()
                    }
                }) {
                    Text("Close Drawer")
                }


                Button(onClick = {
                    scope.launch {

                        if (state.drawerState.isOpen)
                            state.drawerState.close()
                    }
                }) {
                    Text("Close Drawer")
                }
            }
        },
        drawerBackgroundColor = Color.LightGray,
        drawerContentColor = Color.Black,
        drawerGesturesEnabled = true,

//        drawerState = drawerState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Body Content")
                Spacer(Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {

                        if (state.drawerState.isClosed)
                            state.drawerState.open()
                    }
                }) {
                    Text("Open Drawer")
                }
            }
        }
    )
}