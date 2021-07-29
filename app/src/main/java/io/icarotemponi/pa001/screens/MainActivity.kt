package io.icarotemponi.pa001.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.icarotemponi.pa001.R
import io.icarotemponi.pa001.screens.rentcalculator.RentCalculatorPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContainer {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = "rentcalculator",
                    builder = {
                        composable("rentcalculator", content = { RentCalculatorPage() })
                    }
                )
            }
        }
    }
}

@Composable
private fun AppContainer(content: @Composable() () -> Unit) {
    MaterialTheme(
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("PA001", textAlign = TextAlign.Center) }
                    )
                },
                content = {
                    content()
                }
            )
        },
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
            secondary = colorResource(id = R.color.secondary),
            secondaryVariant = colorResource(id = R.color.secondary_variant),
        )
    )
}