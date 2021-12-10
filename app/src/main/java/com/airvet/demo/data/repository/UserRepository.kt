package com.airvet.demo.data.repository

import androidx.lifecycle.MutableLiveData
import com.airvet.demo.data.model.ResultModel

interface UserRepository {
    fun getAllUsers(resultLiveData: MutableLiveData<ResultModel>)

}