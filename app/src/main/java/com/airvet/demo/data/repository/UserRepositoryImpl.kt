package com.airvet.demo.data.repository

import androidx.lifecycle.MutableLiveData
import com.airvet.demo.data.model.ResultModel
import com.airvet.demo.data.model.UserData
import com.airvet.demo.retrofit.GetDataService
import com.airvet.demo.retrofit.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

@Suppress("UNCHECKED_CAST")
class UserRepositoryImpl : UserRepository {
    override fun getAllUsers(resultLiveData: MutableLiveData<ResultModel>) {
        val retrofitClientInstance =
            RetrofitClientInstance().getRetrofitInstance()?.create(GetDataService::class.java)
        retrofitClientInstance?.getAllUsers()?.enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                resultLiveData.postValue(ResultModel.Success(response.body()))
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                resultLiveData.postValue(ResultModel.Failure(throw Exception()))
            }
        })
    }

}