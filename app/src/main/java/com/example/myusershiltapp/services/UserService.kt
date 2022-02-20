package com.example.myusershiltapp.services

import com.example.myusershiltapp.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): Response<UserResponse>
}