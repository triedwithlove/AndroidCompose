package com.koueka.dessertclicker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel: ViewModel() {
    //
    //var revenue by rememberSaveable { mutableStateOf(0) }

    private var _dcUiState = MutableStateFlow(DessertClickerUiState())
    val dcUiState: StateFlow<DessertClickerUiState> = _dcUiState.asStateFlow()


    fun updateRevenue(price: Int) {
        _dcUiState.update { stateParam ->
            stateParam.copy(revenue = _dcUiState.value.revenue + price )
        }
    }

    fun incrementDessertSold() {
        _dcUiState.update { param ->
            param.copy(dessertsSold = _dcUiState.value.dessertsSold + 1)
        }
    }

}