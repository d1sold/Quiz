package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton

class Profile : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val homeBut = findViewById<AppCompatImageButton>(R.id.homeButton)

        homeBut.setOnClickListener {
            val relocate = Intent(this, MainMenu::class.java)
            startActivity(relocate)
        }
    }
}