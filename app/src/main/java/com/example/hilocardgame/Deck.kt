package com.example.hilocardgame

class Deck () {
    var cardList = mutableListOf<Card>()
    lateinit var currentCard: Card
    lateinit var nextCard: Card

    init {
        cresteCards()
    }

fun cresteCards (){
    cardList.add(Card(14,"clubs", R.drawable.clubs_ace))
    cardList.add(Card(13,"clubs", R.drawable.clubs_king))
    cardList.add(Card(12,"clubs", R.drawable.clubs_queen))
    cardList.add(Card(11,"clubs", R.drawable.clubs_jack))
    cardList.add(Card(10,"clubs", R.drawable.clubs10))
    cardList.add(Card(9,"clubs", R.drawable.clubs9))
    cardList.add(Card(8,"clubs", R.drawable.clubs8))
    cardList.add(Card(7, "clubs",R.drawable.clubs7))
    cardList.add(Card(6,"clubs", R.drawable.clubs6))
    cardList.add(Card(5,"clubs", R.drawable.clubs5))
    cardList.add(Card(4,"clubs", R.drawable.clubs4))
    cardList.add(Card(3,"clubs", R.drawable.clubs3))
    cardList.add(Card(2,"clubs", R.drawable.clubs2))
    cardList.add(Card(14,"diamonds", R.drawable.diamonds_ace))
    cardList.add(Card(13,"diamonds", R.drawable.diamonds_king))
    cardList.add(Card(12,"diamonds", R.drawable.diamonds_queen))
    cardList.add(Card(11,"diamonds", R.drawable.diamonds_jack))
    cardList.add(Card(10,"diamonds", R.drawable.diamonds10))
    cardList.add(Card(9,"diamonds", R.drawable.diamonds9))
    cardList.add(Card(8,"diamonds", R.drawable.diamonds8))
    cardList.add(Card(7,"diamonds", R.drawable.diamonds7))
    cardList.add(Card(6,"diamonds", R.drawable.diamonds6))
    cardList.add(Card(5,"diamonds", R.drawable.diamonds5))
    cardList.add(Card(4,"diamonds", R.drawable.diamonds4))
    cardList.add(Card(3,"diamonds", R.drawable.diamonds3))
    cardList.add(Card(2, "diamonds",R.drawable.diamonds2))
    cardList.add(Card(14, "spades",R.drawable.spades_ace))
    cardList.add(Card(13, "spades",R.drawable.spades_king))
    cardList.add(Card(12,"spades", R.drawable.spades_queen))
    cardList.add(Card(11,"spades", R.drawable.spades_jack))
    cardList.add(Card(10,"spades", R.drawable.spades10))
    cardList.add(Card(9,"spades", R.drawable.spades9))
    cardList.add(Card(8, "spades",R.drawable.spades8))
    cardList.add(Card(7,"spades", R.drawable.spades7))
    cardList.add(Card(6,"spades", R.drawable.spades6))
    cardList.add(Card(5,"spades", R.drawable.spades5))
    cardList.add(Card(4,"spades", R.drawable.spades4))
    cardList.add(Card(3,"spades", R.drawable.spades3))
    cardList.add(Card(2,"spades", R.drawable.spades2))
    cardList.add(Card(14, "hearts",R.drawable.hearts_ace))
    cardList.add(Card(13, "hearts",R.drawable.hearts_king))
    cardList.add(Card(12,"hearts", R.drawable.hearts_queen))
    cardList.add(Card(11,"hearts", R.drawable.hearts_jack))
    cardList.add(Card(10,"hearts", R.drawable.hearts10))
    cardList.add(Card(9,"hearts", R.drawable.hearts9))
    cardList.add(Card(8,"hearts", R.drawable.hearts8))
    cardList.add(Card(7,"hearts", R.drawable.hearts7))
    cardList.add(Card(6,"hearts", R.drawable.hearts6))
    cardList.add(Card(5,"hearts", R.drawable.hearts5))
    cardList.add(Card(4,"hearts", R.drawable.hearts4))
    cardList.add(Card(3,"hearts", R.drawable.hearts3))
    cardList.add(Card(2,"hearts", R.drawable.hearts2))
}

    fun getNewCard () : Card {
        val rnd = (0 until cardList.size).random()
        currentCard = cardList [rnd]
        nextCard = cardList.removeAt(0)
        return nextCard
    }
}

