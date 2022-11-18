package com.example.hilocardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var roundTextView: TextView
    lateinit var rightAnswersTextView: TextView

    lateinit var questionTextView: TextView
    lateinit var guessTextView: TextView

    var wrongGuesses = 3
    var correctAnswer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        roundTextView = findViewById(R.id.roundTextView)
        roundTextView.text = "LIFE️  ❤️️ :  $wrongGuesses"
        rightAnswersTextView = findViewById(R.id.rightAnswers)
        rightAnswersTextView.text = "SCORE : $correctAnswer"

        questionTextView = findViewById(R.id.question)
        questionTextView.text = "Do you think the next card is\nhigher or lower?"
        guessTextView = findViewById(R.id.guess)
        guessTextView.text = "Let´s  guess !!"

    }
    fun gameOver(view : View){
        val intent = Intent (this,RestartActivity::class.java)
        startActivity(intent)
    }
}