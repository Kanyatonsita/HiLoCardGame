package com.example.hilocardgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class RestartActivity : AppCompatActivity() {

    lateinit var gameOver : TextView
    lateinit var youScore : TextView
    lateinit var hiScore  : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart)

        gameOver = findViewById(R.id.gameOverTextView)
        youScore = findViewById(R.id.youScore)
        hiScore = findViewById(R.id.hiScore)

        //Använd SharedPreferences
        //i restart aktivitet läs om det finns ett värde sparat i shared prefernces och spara i hScore
        val sharedPref = getSharedPreferences("score", Context.MODE_PRIVATE)
        val hScore = sharedPref.getInt("hiScore",0)

        val yScore = intent.getIntExtra("youScore",0)


        gameOver.text = "GAME OVER !!"

        youScore.text = "You score is: $yScore "

        hiScore.text = "Hi score is: $hScore"


        //if-sat
        if (yScore > hScore){
        val preferences = getSharedPreferences("score", Context.MODE_PRIVATE);
        val editor = preferences.edit();
        editor.putInt("hiScore", yScore);
        editor.apply();
        hiScore.text ="Woooooohoo God job!! \n" + "\n   New hi score is : $yScore"
        }
    }

    fun restarGameCard(view : View){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

}

