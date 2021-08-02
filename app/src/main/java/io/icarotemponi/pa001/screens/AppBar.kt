package io.icarotemponi.pa001.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import io.icarotemponi.pa001.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppBar(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    TopAppBar(
        title = { Text("PA001", textAlign = TextAlign.Center) },
        backgroundColor = colorResource(id = R.color.primary),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = { scope.launch { scaffoldState.drawerState.open() } }
            ) {
                Icon(Icons.Filled.Menu, "")
            }
        }
    )
}