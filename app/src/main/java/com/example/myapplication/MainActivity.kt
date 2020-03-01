package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.login_btn)
        val reg: TextView = findViewById(R.id.login_reg)

        btn.setOnClickListener {
            sharePreference()
        }

        reg.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun sharePreference() {
        val name: TextView = findViewById(R.id.login_name)
        val mail: EditText = findViewById(R.id.login_mail)
        val pw: EditText = findViewById(R.id.login_pw)

        if (mail.text.isNotEmpty() && pw.text.isNotEmpty()){
            //Toast.makeText(this, "No data is loaded", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DataList::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Symbols * are required", Toast.LENGTH_SHORT).show()
        }

//        val sharePreFile: SharedPreferences = this.getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
//        val editor: SharedPreferences.Editor = sharePreFile.edit()
//
//        editor.clear().commit()

//        editor.putString("Name", name.text.toString())
//        editor.putString("Mail", mail.text.toString())
//        editor.putString("Password", pw.text.toString())
//
//        editor.apply()
//        editor.commit()
//
//        val preName = sharePreFile.getString("Name", "NoName")
//        val preMail = sharePreFile.getString("Mail", "NoMail")
//        val prePw = sharePreFile.getString("Password", "NoPW")
//
//        Toast.makeText(this, "Name: ${preName.toString()}" +
//                "\nMail: ${preMail.toString()}" +
//                "\nPassword: ${prePw.toString()}",
//            Toast.LENGTH_SHORT).show()
    }
}
