package com.example.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.UserAdapter
import com.example.myapplication.Room.UserListDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DataList: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.datalist)

        var ftn_btn: FloatingActionButton = findViewById(R.id.ft_btn)
        var rv: RecyclerView = findViewById(R.id.data_rv)

        var list: UserListDao


    }
}