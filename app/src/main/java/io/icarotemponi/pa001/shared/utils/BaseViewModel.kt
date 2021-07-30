package io.icarotemponi.pa001.shared.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map

class BaseViewModel<T>(initialState: T) : ViewModel() {
    private val state = MutableStateFlow(initialState)

    @Composable
    fun collectAsState(): State<T> = state.collectAsState()

    @Composable
    fun <R> collectAsState(mapper: (T) -> R): State<R> {
        return state
            .map { mapper(it) }
            .distinctUntilChanged()
            .collectAsState(initial = mapper(state.value))
    }
}