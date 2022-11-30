package com.example.hilocardgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit

class RestartActivity : AppCompatActivity() {

    lateinit var gameOver : TextView
    lateinit var yourScore : TextView
    lateinit var hiScore  : TextView
    lateinit var correctView: KonfettiView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restart)

        gameOver = findViewById(R.id.gameOverTextView)
        yourScore = findViewById(R.id.youScore)
        hiScore = findViewById(R.id.hiScore)
        correctView = findViewById(R.id.correctView)

        //Använd SharedPreferences
        //i restart aktivitet läs om det finns ett värde sparat i shared prefernces och spara i hScore
        val sharedPref = getSharedPreferences("score", Context.MODE_PRIVATE)
        val hScore = sharedPref.getInt("hiScore",0)

        val yScore = intent.getIntExtra("yourScore",0)


        gameOver.text = "GAME OVER !!"

        yourScore.text = "Your score is: $yScore "

        hiScore.text = "Hi score is: $hScore"


        //if-sat
        if (yScore > hScore){
        val preferences = getSharedPreferences("score", Context.MODE_PRIVATE);
        val editor = preferences.edit();
        editor.putInt("hiScore", yScore);
        editor.apply();
        hiScore.text ="Woooooohoo Good job!! \n" + "\n   New hi score is : $yScore"
            correctView.start(
                Party(
                angle = 10,
                speed = 0f,
                maxSpeed = 50f,
                damping = 0.9f,
                spread = 360,
                colors = listOf(0xfb8500, 0xffb703,0x023047, 0x219ebc),
                position = Position.Relative(0.5,0.3),
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100))
            )
        }
    }

    fun restarGameCard(view : View){
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

}

