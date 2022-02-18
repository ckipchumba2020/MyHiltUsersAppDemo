package com.example.myusershiltapp.repositories

import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.models.UserResponseItem
import com.example.myusershiltapp.services.UserService
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val userService: UserService) {
    suspend fun getUsers(): Response<UserResponse> {
        return userService.getUsers()
    }
}