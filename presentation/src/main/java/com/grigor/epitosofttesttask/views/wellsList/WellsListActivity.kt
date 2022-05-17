package com.grigor.epitosofttesttask.views.wellsList

import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.grigor.domain.entities.models.states.WellsListState
import com.grigor.domain.entities.models.wellsListIntent.WellsListIntent
import com.grigor.epitosofttesttask.baseFeatures.BaseActivity
import com.grigor.epitosofttesttask.databinding.ActivityWellsListBinding
import com.grigor.epitosofttesttask.views.wellsList.viewModel.WellsListViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class WellsListActivity : BaseActivity<ActivityWellsListBinding>() {

    override val inflater: (LayoutInflater) -> ActivityWellsListBinding
        get() = ActivityWellsListBinding::inflate

    private val wellsListViewModel by viewModel<WellsListViewModel>()

    override fun initViews() {

    }

    override fun initViewModel() {
        super.initViewModel()
        fetchData()
        lifecycleScope.launch(Dispatchers.Main) {
            wellsListViewModel.mainStateFlow.collect {
                chooseState(it)
            }
        }
    }

    override fun <T> chooseState(state: T) {
        super.chooseState(state)
        when (state) {
            is WellsListState.WellsList -> {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
            is WellsListState.IsLoading -> {
                onLoading()
            }
            is WellsListState.Error -> {
                onError(state.message) {
                    fetchData()
                }
            }
            else -> {
                return
            }
        }
    }

    private fun fetchData() {
        lifecycleScope.launch(Dispatchers.IO) {
            wellsListViewModel.baseIntentChannel.send(WellsListIntent.FetchUser)
        }
    }
}