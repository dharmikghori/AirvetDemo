package com.airvet.demo.data.model

sealed class ResultModel {
    data class Success<T>(val data: T) : ResultModel()
    data class Failure(val exception: Exception) : ResultModel()
    data class DataSending<T>(val data: T) : ResultModel()
    object Loading : ResultModel()
}