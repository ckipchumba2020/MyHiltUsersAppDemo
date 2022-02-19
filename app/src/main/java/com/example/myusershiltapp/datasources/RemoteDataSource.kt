package com.example.myusershiltapp.datasources

import android.util.Log
import com.example.myusershiltapp.ResponseResult
import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.services.UserService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val userService: UserService) {
    private val _tag: String = "RemoteDataSource"
    /**
     * Get Users from Remote Data Source
     * Returns a Response Result
     */
    suspend fun getUsersResult(): ResponseResult<UserResponse> {
        return try {
            val response = userService.getUsers()

            return if (response.isSuccessful) {
                ResponseResult(ResponseResult.Status.SUCCESS, response.body(), null, null)
            } else {
                Log.d(_tag, "Exception: " + response.code())

                ResponseResult(ResponseResult.Status.ERROR, null, null, "Error ${response.message()}")
            }
        } catch (e: Exception) {
            Log.d(_tag, "Exception: " + e.message)
            ResponseResult(ResponseResult.Status.ERROR, null, null, "Unknown Error.")
        }

    }
}
