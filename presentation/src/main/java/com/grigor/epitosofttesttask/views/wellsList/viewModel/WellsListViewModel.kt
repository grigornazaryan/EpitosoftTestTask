package com.grigor.epitosofttesttask.views.wellsList.viewModel

import androidx.lifecycle.viewModelScope
import com.grigor.domain.entities.models.states.WellsListState
import com.grigor.domain.entities.models.wellsListIntent.WellsListIntent
import com.grigor.domain.usecaseHelper.WellsListUseCaseHelper
import com.grigor.epitosofttesttask.baseFeatures.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class WellsListViewModel(private val wellsListUseCaseHelper: WellsListUseCaseHelper) :
    BaseViewModel<WellsListIntent>() {

    private val _mainStateFlow = MutableStateFlow<WellsListState?>(null)
    val mainStateFlow get() = _mainStateFlow.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            baseIntentChannel.consumeAsFlow().collect {
                when (it) {
                    is WellsListIntent.FetchUser -> {
                        _mainStateFlow.value = WellsListState.IsLoading
                        _mainStateFlow.value = wellsListUseCaseHelper.fetchWellSites()
                    }
                }
            }
        }
    }

}