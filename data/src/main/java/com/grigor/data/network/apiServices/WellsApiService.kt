package com.grigor.data.network.apiServices

import com.grigor.domain.entities.constants.NetworkConstants
import com.grigor.domain.entities.models.dataModels.WellsApiResponseDataModel
import retrofit2.Response
import retrofit2.http.GET

interface WellsApiService {

    @GET(NetworkConstants.FETCHWELLSITES)
    suspend fun fetchWellSites(): Response<WellsApiResponseDataModel>

}