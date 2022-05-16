package com.grigor.data.network.apiHelpers

import com.grigor.data.network.apiServices.WellsApiService
import com.grigor.domain.entities.models.base.BaseResponseModel
import com.grigor.domain.entities.models.dataModels.WellSitesDataModel

class WellsApiHelper(private val wellsApiService: WellsApiService) {

    suspend fun fetchWellSites(): BaseResponseModel<ArrayList<WellSitesDataModel>> {
        val response = wellsApiService.fetchWellSites()
     return  if (response.isSuccessful) {
            BaseResponseModel.Success(response.body()?.wellsites)
        }
        else{
            BaseResponseModel.Error(response.message())
        }
    }
}