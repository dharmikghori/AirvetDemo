package com.airvet.demo.retrofit

import com.airvet.demo.data.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("?page=1&results=50")
    fun getAllUsers(): Call<UserData>

}