package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity: AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun blockNumbersAndSymbols(dataUser: EditText) {
            dataUser.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(editable: Editable?) {
                    val input = editable.toString()
                    val onlyLetters = input.replace(Regex("[^a-zA-Zа-яА-Я]+"), "")
                    if (input != onlyLetters) {
                        dataUser.setText(onlyLetters)
                        dataUser.setSelection(onlyLetters.length)
                    }
                }
            })
        }

        var but = findViewById<Button>(R.id.button4)
        var registerButton = findViewById<Button>(R.id.register)
        var anonimRegButton = findViewById<Button>(R.id.anonimReg)
        val dataUser = findViewById<EditText>(R.id.editText)
        blockNumbersAndSymbols(dataUser)
        var registerText = findViewById<TextView>(R.id.registerText)


        fun RegInvisible() {
            but.visibility = View.VISIBLE
            dataUser.visibility = View.VISIBLE
            registerText.visibility = View.VISIBLE
            registerButton.visibility = View.GONE
            anonimRegButton.visibility = View.GONE
        }

        registerButton.setOnClickListener {
            RegInvisible()
        }

        but.setOnClickListener {
            if(dataUser.text.toString().length > 0){
                val relocate = Intent(this, MainMenu::class.java)
                startActivity(relocate)

            }
            else {
                Toast.makeText(applicationContext, "Не зарегестрированы!", Toast.LENGTH_SHORT).show()
            }
        }
        anonimRegButton.setOnClickListener {
            val relocate = Intent(this, MainMenu::class.java)
            startActivity(relocate)
        }
    }
}