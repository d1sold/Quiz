package com.example.myapplication123

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuizGame : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    var questions = listOf(
        " Тесак жив? \n\n A) Да \n\n B) Нет \n\n C) Братство солнца",
        " Где больше сборки модов? \n\n A) TES: Skyrim \n\n B) Minecraft \n\n C) Terraria",
        " Кто щас в мете? \n\n A) Pudge \n\n B) Tinker \n\n C) Techies",
        " Сколько стоит грамм))) \n\n A) 2000 \n\n B) 1500 \n\n C) 2500",
        " Когда выйдет GTA VI на PC \n\n A) 2026 \n\n B) 2027 \n\n C) Не выйдет",
        " Разраб лох? \n\n A) Да \n\n B) Захар \n\n C) Нет",
        " Продолжи строчку песни: \"Проснулся дал...\" \n\n A) дымка \n\n B) джазику \n\n C) зазу")

    var rightAnswers = listOf(3, 1, 1, 3, 1, 3, 3)

    lateinit var butA: Button
    lateinit var butGo: Button
    lateinit var butB: Button
    lateinit var butC: Button
    lateinit var butQuestion: TextView
    var questionNo = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz_game)

        butGo = findViewById(R.id.buttonGo)
        butA = findViewById<Button>(R.id.buttonA)
        butB = findViewById<Button>(R.id.buttonB)
        butC = findViewById<Button>(R.id.buttonC)
        butQuestion = findViewById<TextView>(R.id.Questions)

        butGo.setOnClickListener {
            GoInvisible()
            showToast(1)
        }
        butA.setOnClickListener {
            showToast(1)
        }

        butB.setOnClickListener {
            showToast(2)
        }

        butC.setOnClickListener {
            showToast(3)
        }
    }

    fun GoInvisible() {
        butA.visibility = View.VISIBLE
        butB.visibility = View.VISIBLE
        butC.visibility = View.VISIBLE
        butGo.visibility = View.GONE
    }

    fun updateQuestion() {
        if (questionNo == 6){
            Toast.makeText(applicationContext, "End", Toast.LENGTH_SHORT).show()
            val relocate = Intent(this, TaskResoult::class.java)
            startActivity(relocate)
        }
        else{
            questionNo += 1
            butQuestion.setText(questions.get(questionNo))
        }
    }

    fun showToast(answer: Int) {
        if (answer == rightAnswers.get(questionNo)) {
            Toast.makeText(applicationContext, "CORRECT!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(applicationContext, "WRONG!", Toast.LENGTH_SHORT).show()
        }
        updateQuestion()
    }
}
