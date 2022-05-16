package com.grigor.domain.usecase

import com.grigor.domain.entities.constants.ExceptionConstants
import com.grigor.domain.entities.models.base.BaseResponseModel
import com.grigor.domain.entities.models.states.WellsListState
import com.grigor.domain.exceptions.NoInternetException
import com.grigor.domain.repository.WellsListRepository
import com.grigor.domain.usecaseHelper.WellsListUseCaseHelper
import java.io.IOException

class WellsListUseCase(private val wellsListRepository: WellsListRepository) :
    WellsListUseCaseHelper {

    override suspend fun fetchWellSites(): WellsListState {
        return try {
            when (val response = wellsListRepository.fetchWellSites()) {
                is BaseResponseModel.Success -> {
                    return WellsListState.WellsList(ArrayList(response.data?: arrayListOf()))
                }
                is BaseResponseModel.Error -> {
                    return WellsListState.Error(response.error)
                }
                else -> {
                    return WellsListState.Error(ExceptionConstants.SOMETHING_WENT_WRONG)
                }
            }
        }catch (e:NoInternetException){
            WellsListState.Error(ExceptionConstants.NO_INTERNET)
        }
        catch (e: IOException) {
            WellsListState.Error(ExceptionConstants.SOMETHING_WENT_WRONG)
        }
    }
}