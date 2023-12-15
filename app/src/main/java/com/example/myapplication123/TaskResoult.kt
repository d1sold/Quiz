package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TaskResoult: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.taskresoult)

        val but1 = findViewById<Button>(R.id.showresoult)
        val but2 = findViewById<Button>(R.id.exit)
        val but3 = findViewById<Button>(R.id.restrart)
        val happy = findViewById<TextView>(R.id.happy)
        val balli = findViewById<TextView>(R.id.balli)
        val resoultsText = findViewById<TextView>(R.id.resoultsText)

        fun invisible() {
            resoultsText.visibility = View.VISIBLE
            balli.visibility = View.VISIBLE
            happy.visibility = View.VISIBLE
            but3.visibility = View.VISIBLE
            but2.visibility = View.VISIBLE
        }
        but1.setOnClickListener {
            invisible()
        }
        but2.setOnClickListener {
            val relocate = Intent(this, MainMenu::class.java)
            startActivity(relocate)
        }
        but3.setOnClickListener {
            val relocate = Intent(this, QuizGame::class.java)
            startActivity(relocate)
        }
    }
}