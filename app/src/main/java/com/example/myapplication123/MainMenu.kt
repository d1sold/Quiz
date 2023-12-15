package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class MainMenu: AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        var but1 = findViewById<ImageButton>(R.id.imageButton1)
        var but2 = findViewById<ImageButton>(R.id.imageButton2)
        var profile = findViewById<AppCompatImageButton>(R.id.avatarProfile)

        profile.setOnClickListener {
            val relocate = Intent(this, Profile::class.java)
            startActivity(relocate)
        }
        but1.setOnClickListener {
            val relocate = Intent(this, QuizGame::class.java)
            startActivity(relocate)
        }
        but2.setOnClickListener {
            Toast.makeText(applicationContext, "В разработке", Toast.LENGTH_SHORT).show()
        }
    }
}