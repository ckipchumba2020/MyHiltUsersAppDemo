package com.example.myusershiltapp.models


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    val id: Int,

    @Embedded
    val address: Address?,

    @Embedded
    val company: Company?,

    val email: String?,
    val name: String?,
    val phone: String?,
    val username: String?,
    val website: String?
)