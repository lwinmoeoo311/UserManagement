package com.example.myapplication.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userList")
data class UserList(

    @PrimaryKey(autoGenerate = true)
    val ID: Int = 0,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "age")
    val age: Int = 0,

    @ColumnInfo(name = "mail")
    val mail: String = ""
)