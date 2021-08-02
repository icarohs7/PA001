package io.icarotemponi.pa001.screens.rentcalculator

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import io.icarotemponi.pa001.shared.models.PATimeInterval

@Composable
fun RentCalculatorPage() {
    val viewModel: RentCalculatorViewModel = viewModel()
    val state = viewModel.collectAsState()

}

@Composable
fun PATimeIntervalItem(item: PATimeInterval) {

}