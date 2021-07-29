package io.icarotemponi.pa001.screens.rentcalculator

import androidx.compose.runtime.Composable
import com.airbnb.mvrx.compose.mavericksViewModel
import io.icarotemponi.pa001.shared.models.PATimeInterval

@Composable
fun RentCalculatorPage() {
    val viewModel: RentCalculatorViewModel = mavericksViewModel()
}

@Composable
fun PATimeIntervalItem(item: PATimeInterval) {

}