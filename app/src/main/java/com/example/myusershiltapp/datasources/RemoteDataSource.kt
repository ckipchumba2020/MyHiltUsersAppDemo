package com.example.myusershiltapp.datasources

import android.util.Log
import com.example.myusershiltapp.Result
import com.example.myusershiltapp.Status
import com.example.myusershiltapp.models.User
import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.services.UserService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val userService: UserService) {
    private val _tag: String = "RemoteDataSource"

    /**
     * Get Users from Remote Data Source
     * Returns a Response Result
     */
    suspend fun getUsersResult(): Result<List<User>> {
        return try {
            val response = userService.getUsers()

            return if (response.isSuccessful) {
                Result.success(response.body())
            } else {
                Log.d(_tag, "Exception Response: " + response.code())

                Result.error("Error ${response.message()}")
            }
        } catch (e: Exception) {
            Log.d(_tag, "Exception GetUsers: " + e.message)
            Result.error("Unknown Error. Check Internet Connection.")
        }

    }
}
