package com.example.myapplication.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserList::class], version = 1)
abstract class UserListDb: RoomDatabase() {
    companion object {
        @Volatile
        private var INSTANCE: UserListDb? = null

        fun getInstance(context: Context): UserListDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext, UserListDb::class.java, "userListDb").build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}