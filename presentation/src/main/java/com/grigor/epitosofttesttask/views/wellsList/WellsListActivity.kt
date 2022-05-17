package com.grigor.epitosofttesttask.views.wellsList

import android.view.LayoutInflater
import com.grigor.domain.entities.models.states.WellsListState
import com.grigor.domain.entities.models.wellsListIntent.WellsListIntent
import com.grigor.epitosofttesttask.baseFeatures.BaseActivity
import com.grigor.epitosofttesttask.databinding.ActivityWellsListBinding
import com.grigor.epitosofttesttask.views.wellsList.adapters.WellsListAdapter
import com.grigor.epitosofttesttask.views.wellsList.viewModel.WellsListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class WellsListActivity : BaseActivity<ActivityWellsListBinding>() {

    override val inflater: (LayoutInflater) -> ActivityWellsListBinding
        get() = ActivityWellsListBinding::inflate

    private var wellsAdapter: WellsListAdapter? = null

    private val wellsListViewModel by viewModel<WellsListViewModel>()

    override fun initViews() {
        mBinding.wellsList.adapter = WellsListAdapter().also { wellsAdapter = it }
    }

    override fun initViewModel() {
        super.initViewModel()
        fetchData()
        CoroutineScope(Dispatchers.Main).launch {
            wellsListViewModel.mainStateFlow.collect {
                chooseState(it)
            }
        }
    }

    override fun <T> chooseState(state: T) {
        super.chooseState(state)
        when (state) {
            is WellsListState.WellsList -> {
                wellsAdapter?.setData(state.dataList)

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
        CoroutineScope(Dispatchers.IO).launch {
            wellsListViewModel.baseIntentChannel.send(WellsListIntent.FetchUser)
        }
    }
}