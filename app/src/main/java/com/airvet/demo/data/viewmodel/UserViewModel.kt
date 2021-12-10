package com.airvet.demo.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.airvet.demo.data.model.ResultModel
import com.airvet.demo.data.repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val usersLiveData = MutableLiveData<ResultModel>()
    fun getAllUsers() {
        userRepository.getAllUsers(usersLiveData)
    }

}