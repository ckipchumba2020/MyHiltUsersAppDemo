package com.example.myusershiltapp.models


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Address(
    val city: String?,

    @Embedded
    val geo: Geo?,
    val street: String?,
    val suite: String?,
    val zipcode: String?
)