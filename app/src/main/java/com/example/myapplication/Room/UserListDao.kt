package com.example.myapplication.Room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserListDao {
    @Insert
    fun insert(list: UserList)

    @Update
    fun update(list: UserList)

    @Delete
    fun delete(list: UserList)

    @Query("Select * from userList")
    fun getList(): LiveData<List<UserList>>
}