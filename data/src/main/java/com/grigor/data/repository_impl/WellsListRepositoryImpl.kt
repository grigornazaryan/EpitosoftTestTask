package com.grigor.data.repository_impl

import com.grigor.data.network.apiHelpers.WellsApiHelper
import com.grigor.domain.entities.models.base.BaseResponseModel
import com.grigor.domain.entities.models.dataModels.WellSitesDataModel
import com.grigor.domain.repository.WellsListRepository

class WellsListRepositoryImpl(private val wellsApiHelper: WellsApiHelper) : WellsListRepository{

  override suspend fun fetchWellSites(): BaseResponseModel<ArrayList<WellSitesDataModel>> {
        return wellsApiHelper.fetchWellSites()
    }
}