package com.grigor.domain.repository

import com.grigor.domain.entities.models.base.BaseResponseModel
import com.grigor.domain.entities.models.dataModels.WellSitesDataModel

interface WellsListRepository {
   suspend fun fetchWellSites(): BaseResponseModel<ArrayList<WellSitesDataModel>>
}