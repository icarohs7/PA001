package io.icarotemponi.pa001.screens.rentcalculator

import io.icarotemponi.pa001.shared.models.PATimeInterval
import io.icarotemponi.pa001.shared.utils.BaseViewModel

data class RentCalculatorState(
    val items: List<PATimeInterval> = emptyList()
)

class RentCalculatorViewModel : BaseViewModel<RentCalculatorState>(RentCalculatorState())