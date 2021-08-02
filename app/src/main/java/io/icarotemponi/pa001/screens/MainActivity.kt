package io.icarotemponi.pa001.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
            val scope = rememberCoroutineScope()
            val navController = rememberNavController()

            AppContainer {
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = { AppBar(scaffoldState, scope) },
                    drawerContent = { AppDrawer(navController, scope, scaffoldState) },
                    content = { AppContent(navController) }
                )
            }
        }
    }
}
