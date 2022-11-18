package com.example.hilocardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class RestartActivity : AppCompatActivity() {

    lateinit var gameOver : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart)

        gameOver = findViewById(R.id.gameOverTextView)

        gameOver.text = "GAME OVER !!"

    }

    fun restarGameCard(view : View){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)

    }
}