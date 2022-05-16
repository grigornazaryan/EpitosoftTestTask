package com.grigor.domain.usecaseHelper

import com.grigor.domain.entities.models.states.WellsListState


interface WellsListUseCaseHelper {
    suspend fun fetchWellSites(): WellsListState
}