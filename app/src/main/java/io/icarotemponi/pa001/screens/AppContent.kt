package io.icarotemponi.pa001.screens

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import io.icarotemponi.pa001.R

@Composable
fun AppContent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "rentcalculator",
        builder = {
        }
    )
}

@Composable
fun AppContainer(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        content = content,
        typography = Typography(
            body1 = TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            )
        ),
        shapes = Shapes(
            small = RoundedCornerShape(4.dp),
            medium = RoundedCornerShape(4.dp),
            large = RoundedCornerShape(0.dp)
        ),
        colors = darkColors(
            primary = colorResource(id = R.color.primary),
            primaryVariant = colorResource(id = R.color.primary_variant),
            onPrimary = colorResource(id = R.color.on_primary),
            secondary = colorResource(id = R.color.secondary),
            secondaryVariant = colorResource(id = R.color.secondary_variant),
            onSecondary = colorResource(id = R.color.on_secondary),
        )
    )
}