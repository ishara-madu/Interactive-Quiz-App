package com.pixeleye.myapplication

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var progressText: TextView
    private lateinit var title: TextView
    private lateinit var flag: ImageView
    private lateinit var option1: TextView
    private lateinit var option2: TextView
    private lateinit var option3: TextView
    private lateinit var option4: TextView
    private lateinit var submit : Button
    private var currentPosition:Int = 0
    private var questionList = Constant.getQuestion()
    private var selectedOption:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        progressBar = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.prgressStatue)
        title = findViewById(R.id.question)
        flag = findViewById(R.id.flagIcon)
        option1 = findViewById(R.id.firstAnswer)
        option2 = findViewById(R.id.secondAnswer)
        option3 = findViewById(R.id.thirdAnswer)
        option4 = findViewById(R.id.fourthAnswer)
        submit = findViewById(R.id.submitButton)

        setQuestion()


        submit.setOnClickListener{
            submit()
        }

        option1.setOnClickListener {
            selectedOption = 0
            clearSelection()
            option1.typeface = Typeface.DEFAULT_BOLD
            option1.background = ContextCompat.getDrawable(this, R.drawable.button_selected)
        }
        option2.setOnClickListener {
            selectedOption = 1
            clearSelection()
            option2.typeface = Typeface.DEFAULT_BOLD
            option2.background = ContextCompat.getDrawable(this, R.drawable.button_selected)
        }
        option3.setOnClickListener {
            selectedOption = 2
            clearSelection()
            option3.typeface = Typeface.DEFAULT_BOLD
            option3.background = ContextCompat.getDrawable(this, R.drawable.button_selected)
        }
        option4.setOnClickListener {
            selectedOption = 3
            clearSelection()
            option4.typeface = Typeface.DEFAULT_BOLD
            option4.background = ContextCompat.getDrawable(this, R.drawable.button_selected)
        }



    }
    private fun setQuestion() {
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

    private fun clearSelection() {
        option1.typeface = Typeface.DEFAULT
        option2.typeface = Typeface.DEFAULT
        option3.typeface = Typeface.DEFAULT
        option4.typeface = Typeface.DEFAULT
        option1.background = ContextCompat.getDrawable(this, R.drawable.button)
        option2.background = ContextCompat.getDrawable(this, R.drawable.button)
        option3.background = ContextCompat.getDrawable(this, R.drawable.button)
        option4.background = ContextCompat.getDrawable(this, R.drawable.button)
    }

    private fun submit() {
        if(submit.text == "Submit"){
            if(selectedOption == null){
                Toast.makeText(this,"Please select an option",Toast.LENGTH_SHORT).show()
            }else {
                submit.text = "Next"
                val question = questionList[currentPosition]
                if (selectedOption == question.correctAnswer) {
                    correctAnswer(selectedOption)
                } else {
                    correctAnswer(question.correctAnswer)
                    wrongAnswer(selectedOption)
                }
            }
        }else{
                currentPosition++
                setQuestion()
                submit.text = "Submit"
                clearSelection()
        }
    }
    private fun correctAnswer(option: Int) {
        var listOption = ArrayList<TextView>()
        listOption.add(option1)
        listOption.add(option2)
        listOption.add(option3)
        listOption.add(option4)
        listOption[option].typeface = Typeface.DEFAULT_BOLD
        listOption[option].background = ContextCompat.getDrawable(this, R.drawable.button_correct)

    }
    private fun wrongAnswer(option: Int) {
        var listOption = ArrayList<TextView>()
        listOption.add(option1)
        listOption.add(option2)
        listOption.add(option3)
        listOption.add(option4)
        listOption[option].typeface = Typeface.DEFAULT
        listOption[option].background = ContextCompat.getDrawable(this, R.drawable.button_wrong)

    }


}