package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Register: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val register = findViewById<Button>(R.id.reg_btn)

        register.setOnClickListener{ registerPreFile() }
    }

    private fun registerPreFile() {

        val nameReg: EditText = findViewById(R.id.reg_name)
        val mailReg: EditText = findViewById(R.id.reg_mail)
        val pwReg: EditText = findViewById(R.id.reg_pw)
        val confirmPwReg: EditText = findViewById(R.id.reg_pw_confirm)

        val registerPreFile: SharedPreferences = this.getSharedPreferences("This is register", Context.MODE_PRIVATE)
        val editor = registerPreFile.edit()

        editor.putString("Name_reg", nameReg.toString())
        editor.putString("Mail_reg", mailReg.toString())
        editor.putString("PW_reg", pwReg.toString())
        editor.putString("Confirm_PW_reg", confirmPwReg.toString())

        editor.apply()
        editor.commit()

        val intent = Intent(this, DataList::class.java)
        startActivity(intent)
        finish()
    }
}