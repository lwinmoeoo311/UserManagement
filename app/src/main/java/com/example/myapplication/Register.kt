package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.register.*

class Register: AppCompatActivity() {

    private lateinit var base: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        base = FirebaseAuth.getInstance()

        val register = findViewById<Button>(R.id.reg_btn)

        register.setOnClickListener{ createUser() }
    }

    private fun createUser() {
        if (reg_name.text.toString().isNullOrEmpty() || reg_mail.text.toString().isNullOrEmpty() ||
                reg_pw.text.toString().isNullOrEmpty() || reg_pw_confirm.text.isNullOrEmpty()) {
            Toast.makeText(this, "Fields marked * are required to fill", Toast.LENGTH_SHORT).show()

        }
        else if (reg_pw.text.equals(reg_pw_confirm.text)) {
            Toast.makeText(this, "Your password confirmation is not correct", Toast.LENGTH_SHORT).show()
        }
        else {
            base.createUserWithEmailAndPassword(reg_mail.text.toString(), reg_pw.text.toString())
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        base.currentUser
                        val intent = Intent(this, DataList::class.java)
                        startActivity(intent)
                    }
                }
        }
    }
}

//private fun registerPreFile() {
//
//    val nameReg: EditText = findViewById(R.id.reg_name)
//    val mailReg: EditText = findViewById(R.id.reg_mail)
//    val pwReg: EditText = findViewById(R.id.reg_pw)
//    val confirmPwReg: EditText = findViewById(R.id.reg_pw_confirm)
//
//    val registerPreFile: SharedPreferences = this.getSharedPreferences("This is register", Context.MODE_PRIVATE)
//    val editor = registerPreFile.edit()
//
//    editor.putString("Name_reg", nameReg.toString())
//    editor.putString("Mail_reg", mailReg.toString())
//    editor.putString("PW_reg", pwReg.toString())
//    editor.putString("Confirm_PW_reg", confirmPwReg.toString())
//
//    editor.apply()
//    editor.commit()
//
//    val intent = Intent(this, DataList::class.java)
//    startActivity(intent)
//    finish()
//}