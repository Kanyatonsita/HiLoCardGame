package com.example.hilocardgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.Position
import nl.dionsegijn.konfetti.core.emitter.Emitter
import nl.dionsegijn.konfetti.xml.KonfettiView
import java.util.concurrent.TimeUnit
import kotlin.math.log

class GameActivity : AppCompatActivity() {

    lateinit var lifeTextView: TextView
    var wrongGuesses = 5

    lateinit var rightAnswersTextView: TextView
    var correctAnswer = 0

    lateinit var questionTextView: TextView
    lateinit var guessTextView: TextView
    lateinit var message: TextView

    lateinit var showCardsImage : ImageView

    lateinit var lifeOneImage : ImageView
    lateinit var lifeTwoImage : ImageView
    lateinit var lifeThreeImage : ImageView
    lateinit var lifeFourImage : ImageView
    lateinit var lifeFiveImage : ImageView

    lateinit var correctView: KonfettiView

    var lifeArrayList = mutableListOf<ImageView>()

    val cardDeck = Deck()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        lifeTextView = findViewById(R.id.lifeTextView)
        rightAnswersTextView = findViewById(R.id.rightAnswers)

        questionTextView = findViewById(R.id.question)
        guessTextView = findViewById(R.id.guess)
        message = findViewById(R.id.massageTextView)

        showCardsImage = findViewById(R.id.CardsImage)

        correctView = findViewById(R.id.correctView)

        lifeOneImage = findViewById(R.id.imageLife1)
        lifeTwoImage = findViewById(R.id.imageLife2)
        lifeThreeImage = findViewById(R.id.imageLife3)
        lifeFourImage = findViewById(R.id.imageLife4)
        lifeFiveImage = findViewById(R.id.imageLife5)

        lifeTextView.text = "LIFE️  ❤️️ :  $wrongGuesses"

        rightAnswersTextView.text = "SCORE : $correctAnswer"

        questionTextView.text = "Do you think the next card is\nhigher or lower?"

        guessTextView.text = "Let´s  guess !!"

        showCardsImage.setImageResource(cardDeck.cardList[0].image)

        val hiButton = findViewById<Button>(R.id.higherButton)
        val loButton = findViewById<Button>(R.id.lowerButton)

        lifeArrayList.add(0,lifeOneImage)
        lifeArrayList.add(1,lifeTwoImage)
        lifeArrayList.add(2,lifeThreeImage)
        lifeArrayList.add(3,lifeFourImage)
        lifeArrayList.add(4,lifeFiveImage)

        setHeart()

        hiButton.setOnClickListener{
            cardDeck.getNewCard()
            if (cardDeck.oldCard.value >= cardDeck.nextCard.value){
                konfettiShow()
                message.text = "Correct, Good jobb!!"
                correctAnswer++
            }else{
                message.text = "Wrong, try again!!"
                wrongGuesses--
                setHeart()
            }
            checkCard()

        }


        loButton.setOnClickListener{
            cardDeck.getNewCard()
            if (cardDeck.oldCard.value <= cardDeck.nextCard.value){
                konfettiShow()
                message.text = "Correct, good job!!"
                correctAnswer++
            }else{
                message.text = "Wrong, try again!!"
                wrongGuesses--
                setHeart()
            }
            checkCard()

        }

    }

    //Function to show confetti.
    private fun konfettiShow(){
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


    //Function to check card and game over.
    private fun checkCard(){
        showCardsImage.setImageResource(cardDeck.oldCard.image)
        rightAnswersTextView.text = "SCORE : $correctAnswer"
        lifeTextView.text = "LIFE️  ❤️️ :  $wrongGuesses"

        if (wrongGuesses == 0) {
            gameOverAndShowScore()
        }
    }

    private fun gameOverAndShowScore(){

        val rightText = rightAnswersTextView.text.toString()
        val ShowScore = rightText.toIntOrNull()

        val intent = Intent (this,RestartActivity::class.java)
        intent.putExtra("yourScore",correctAnswer)

        if (ShowScore == correctAnswer){
            correctAnswer++
        }
        startActivity(intent)
    }

    private fun setHeart(){
        lifeArrayList.forEachIndexed { index, imageView ->
            if (index < wrongGuesses){
                imageView.setBackgroundResource(R.drawable.blackheart)
            }else{
                imageView.setBackgroundResource(R.drawable.blank)
            }
        }
    }

    }


