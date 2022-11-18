package com.example.hilocardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var welcomeTextView: TextView
    lateinit var gameTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.gameOverTextView)
        welcomeTextView.text = "Welcome to\nmy card game!!"

        gameTextView = findViewById(R.id.gameNamn)
        gameTextView.text = "High  &  Low  game."

    }
    //Button for start next activity. (Start game!!)
    fun startGameActivity(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}