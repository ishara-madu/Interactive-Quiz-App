package com.pixeleye.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SummeryActivity : AppCompatActivity() {

    private lateinit var title:TextView
    private lateinit var name:TextView
    private lateinit var score:TextView
    private lateinit var finish:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_summery)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            title = findViewById(R.id.greeting)
            name = findViewById(R.id.name)
            score = findViewById(R.id.score)
            finish = findViewById(R.id.finish)

        val mark = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)
        val user = intent.getStringExtra("name") ?: "Unknown"

        if(mark > total/2){
        title.text = "Congratulations"
        name.text = user
        score.text = "$mark/$total"
        finish.setOnClickListener{
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        }
        else{
            title.text = "Oops..."
            title.setTextColor(ContextCompat.getColor(this,R.color.red))
            name.text = user
            score.text = "$mark/$total"
            finish.setBackgroundColor(ContextCompat.getColor(this,R.color.red))
            finish.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}