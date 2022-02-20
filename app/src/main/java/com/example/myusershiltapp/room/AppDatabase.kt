package com.example.myusershiltapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myusershiltapp.models.Address
import com.example.myusershiltapp.models.Company
import com.example.myusershiltapp.models.Geo
import com.example.myusershiltapp.models.User

/**
 * App Database
 * Instantiated by Hilt under the DatabaseModule
 */
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}