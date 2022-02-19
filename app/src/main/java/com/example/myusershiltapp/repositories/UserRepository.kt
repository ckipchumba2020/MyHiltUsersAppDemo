package com.example.myusershiltapp.repositories

import com.example.myusershiltapp.ResponseResult
import com.example.myusershiltapp.datasources.RemoteDataSource
import com.example.myusershiltapp.models.UserResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    /**
     * Returns a Flow of Response Result
     */
    suspend fun getUsersFlow(): Flow<ResponseResult<UserResponse>> {
        return flow {
            emit(ResponseResult.loading())  // emit loading status....

            val responseResult = remoteDataSource.getUsersResult()
            emit(responseResult)           // emit results......
        }
    }
}