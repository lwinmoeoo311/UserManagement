package com.example.myapplication.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.DataList
import com.example.myapplication.R
import com.example.myapplication.Room.UserList

class UserAdapter(val context: Context, val dataList: List<UserList>): RecyclerView.Adapter<UserAdapter.UserHolder>() {

    inner class UserHolder(val view: View): RecyclerView.ViewHolder(view) {
        val edit = view.findViewById<ImageView>(R.id.edit_img)
        val delete = view.findViewById<ImageView>(R.id.delete_img)
        val name = view.findViewById<TextView>(R.id.name_tv)
        val age: TextView = view.findViewById(R.id.age_tv)
        val mail: TextView = view.findViewById(R.id.mail_tv)

        fun setData(dataList: UserList) {
            name.text = dataList.name
            age.text = dataList.age.toString()
            mail.text = dataList.mail
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.sample_datalist, parent, false)

        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val item = dataList[position]
        holder.setData(item)
    }
}