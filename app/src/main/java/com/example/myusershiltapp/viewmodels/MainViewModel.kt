package com.example.myusershiltapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myusershiltapp.Result
import com.example.myusershiltapp.models.User
import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {
    private val _usersResultLiveData: MutableLiveData<Result<List<User>>> = MutableLiveData()

    fun getUsersResult(): MutableLiveData<Result<List<User>>> {
        return _usersResultLiveData
    }

    init {
        loadUsers()
    }

    /**
     * Collects from Repository Flow and Posts Value
     */
    private fun loadUsers() {
        viewModelScope.launch {
            userRepository.getUsersFlow().collect { result ->
                _usersResultLiveData.postValue(result)
            }

        }
    }
}