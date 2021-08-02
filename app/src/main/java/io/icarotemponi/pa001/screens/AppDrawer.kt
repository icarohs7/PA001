package io.icarotemponi.pa001.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import io.icarotemponi.pa001.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    navController: NavHostController,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    Column {
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary),
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        DrawerRoute.values().forEach { route ->
            DrawerNavItem(
                route = route,
                selected = route.route == currentRoute,
                onItemClick = {
                    navController.navigate(route.route) {
                        popUpTo(DrawerRoute.values().first().route) {
                            saveState = true
                            // inclusive = true --enable at version alpha-06
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    scope.launch { scaffoldState.drawerState.close() }
                }
            )
        }
    }
}

@Composable
fun DrawerNavItem(route: DrawerRoute, selected: Boolean, onItemClick: (DrawerRoute) -> Unit) {
    val background = if (selected) R.color.primary_variant else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(route) })
            .height(52.dp)
            .background(colorResource(id = background).copy(alpha = .3f))
            .padding(start = 10.dp)
    ) {
        Image(
            painter = rememberVectorPainter(image = route.icon),
            contentDescription = route.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
        )
        Spacer(modifier = Modifier.width(14.dp))
        Text(
            text = route.title,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}

enum class DrawerRoute(val title: String, val route: String, val icon: ImageVector) {
}