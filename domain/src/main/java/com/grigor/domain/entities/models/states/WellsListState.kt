package com.grigor.domain.entities.models.states

import com.grigor.domain.entities.models.dataModels.WellSitesDataModel

sealed class WellsListState {
    data class WellsList(
        val dataList: ArrayList<WellSitesDataModel> = arrayListOf()
    ) : WellsListState()
    object IsLoading : WellsListState()

    data class Error(val message: String?) : WellsListState()
}