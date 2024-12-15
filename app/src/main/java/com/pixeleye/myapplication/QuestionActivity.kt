package com.pixeleye.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val progressText = findViewById<TextView>(R.id.prgressStatue)
        val title = findViewById<TextView>(R.id.question)
        val flag = findViewById<ImageView>(R.id.flagIcon)
        val option1 = findViewById<TextView>(R.id.firstAnswer)
        val option2 = findViewById<TextView>(R.id.secondAnswer)
        val option3 = findViewById<TextView>(R.id.thirdAnswer)
        val option4 = findViewById<TextView>(R.id.fourthAnswer)


        val questionList = Constant.getQuestion()
        val currentPosition = 0
        val question = questionList[currentPosition]
        progressBar.progress = currentPosition
        progressText.text = "${currentPosition}/${questionList.size}"
        title.text = question.question
        flag.setImageResource(question.image)
        option1.text = question.option1
        option2.text = question.option2
        option3.text = question.option3
        option4.text = question.option4




    }
}