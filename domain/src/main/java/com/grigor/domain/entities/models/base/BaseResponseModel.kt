package com.grigor.domain.entities.models.base

sealed class BaseResponseModel<out S> {
    data class Success<S>(val data: S?) : BaseResponseModel<S>()
    data class Error<E>(val error: String) : BaseResponseModel<E>()
}