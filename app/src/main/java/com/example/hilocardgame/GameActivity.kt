package com.example.hilocardgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var lifeTextView: TextView
    var wrongGuesses = 5

    lateinit var rightAnswersTextView: TextView
    var correctAnswer = 0

    lateinit var questionTextView: TextView
    lateinit var guessTextView: TextView
    lateinit var message: TextView

    lateinit var showCardsImage : ImageView

    val cardDeck = Deck()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        lifeTextView = findViewById(R.id.lifeTextView)
        lifeTextView.text = "LIFE️  ❤️️ :  $wrongGuesses"

        rightAnswersTextView = findViewById(R.id.rightAnswers)
        rightAnswersTextView.text = "SCORE : $correctAnswer"

        questionTextView = findViewById(R.id.question)
        questionTextView.text = "Do you think the next card is\nhigher or lower?"

        guessTextView = findViewById(R.id.guess)
        guessTextView.text = "Let´s  guess !!"

        message = findViewById(R.id.massageTextView)

        showCardsImage = findViewById(R.id.CardsImage)
        showCardsImage.setImageResource(cardDeck.cardList[0].image)


        val hiButton = findViewById<Button>(R.id.higherButton)
        val loButton = findViewById<Button>(R.id.lowerButton)



        hiButton.setOnClickListener{
            cardDeck.getNewCard()
            if (cardDeck.oldCard.value >= cardDeck.nextCard.value){
                message.text = "Correct, Good jobb!!"
                correctAnswer++

            }else{
                message.text = "Wrong, try again!!"
                wrongGuesses--
            }
           checkCard()

        }
        

        loButton.setOnClickListener{
            cardDeck.getNewCard()
            if (cardDeck.oldCard.value <= cardDeck.nextCard.value){
                message.text = "Correct, Good jobb!!"
                correctAnswer++
            }else{
                message.text = "Wrong, try again!!"
                wrongGuesses--
            }
            checkCard()

        }


    }

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
        intent.putExtra("youScore",correctAnswer.toString())
        intent.putExtra("hiScore",correctAnswer.toString())

        if (ShowScore == correctAnswer){
            correctAnswer++
        }
        startActivity(intent)
    }

}

