package com.example.myusershiltapp.repositories

import com.example.myusershiltapp.Result
import com.example.myusershiltapp.Status
import com.example.myusershiltapp.datasources.RemoteDataSource
import com.example.myusershiltapp.models.User
import com.example.myusershiltapp.models.UserResponse
import com.example.myusershiltapp.room.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val userDao: UserDao
) {
    var userList: List<User> = ArrayList<User>()

    /**
     * Returns a Flow of Response Result
     */
    suspend fun getUsersFlow(): Flow<Result<List<User>>> {
        return flow {
             emit(getCachedResult())  // get cached (if any)

            emit(Result.loading(userList))  // emit loading status....

            val responseResult = remoteDataSource.getUsersResult()

            if (responseResult.status == Status.SUCCESS) {
                responseResult.data?.let {
                    userDao.deleteAll(it)       // delete cached
                    userDao.insertAll(it)       // insert latest
                }
                emit(responseResult)           // emit results......
            }

        }.flowOn(Dispatchers.IO)
    }

    private fun getCachedResult(): Result<List<User>> {
        userList = userDao.getAll()
        return Result.success(userList)
    }
}