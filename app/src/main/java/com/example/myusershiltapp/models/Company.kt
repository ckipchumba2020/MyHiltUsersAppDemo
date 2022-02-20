package com.example.myusershiltapp.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Company(
    val bs: String?,
    val catchPhrase: String?,

    @ColumnInfo(name="company_name")
    val name: String?
)