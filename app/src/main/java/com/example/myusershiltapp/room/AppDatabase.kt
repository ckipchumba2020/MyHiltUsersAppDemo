package com.example.myusershiltapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myusershiltapp.models.User

/**
 * App Database
 * Created by Hilt under the DatabaseModule
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao
}