package com.grigor.domain.entities.models.wellsListIntent

sealed class WellsListIntent {
    object FetchUser : WellsListIntent()
}