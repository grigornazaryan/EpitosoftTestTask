package com.grigor.epitosofttesttask.di

import com.grigor.epitosofttesttask.views.wellsList.viewModel.WellsListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationLayerModules= module {
    viewModel { WellsListViewModel(get())}
}