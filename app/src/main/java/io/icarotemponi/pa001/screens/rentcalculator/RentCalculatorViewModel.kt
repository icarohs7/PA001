package io.icarotemponi.pa001.screens.rentcalculator

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import io.icarotemponi.pa001.shared.models.PATimeInterval

data class RentCalculatorState(
    val items: List<PATimeInterval> = emptyList()
) : MavericksState

class RentCalculatorViewModel : MavericksViewModel<RentCalculatorState>(RentCalculatorState())