package com.example.myusershiltapp.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Geo(
    val lat: String?,
    val lng: String?
)