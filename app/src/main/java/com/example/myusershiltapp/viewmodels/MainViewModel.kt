package com.example.myusershiltapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.models.UserResponseItem
import com.example.myusershiltapp.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    private val _usersLiveData: MutableLiveData<UserResponse> = MutableLiveData();

    fun getUsers(): MutableLiveData<UserResponse> {
        return _usersLiveData;
    }

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            val response = userRepository.getUsers()
            if(response.isSuccessful) {
                _usersLiveData.postValue(response.body())

            } else {
                Log.e("MainViewModel", "Error Occurred in loadUsers()")
            }

        }
    }
}