package com.example.myusershiltapp.room

import androidx.room.*
import com.example.myusershiltapp.models.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

    @Delete
    fun deleteAll(users: List<User>)
}