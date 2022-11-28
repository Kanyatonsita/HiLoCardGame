package com.example.hilocardgame

class Deck () {
    var cardList = mutableListOf<Card>()
    lateinit var oldCard: Card
    lateinit var nextCard: Card

    init {
        cresteCards()
        getNewCard()
       cardList.shuffle()
    }

fun cresteCards (){
    cardList.add(Card(14, R.drawable.clubs_ace))
    cardList.add(Card(13, R.drawable.clubs_king))
    cardList.add(Card(12, R.drawable.clubs_queen))
    cardList.add(Card(11, R.drawable.clubs_jack))
    cardList.add(Card(10, R.drawable.clubs10))
    cardList.add(Card(9, R.drawable.clubs9))
    cardList.add(Card(8, R.drawable.clubs8))
    cardList.add(Card(7, R.drawable.clubs7))
    cardList.add(Card(6, R.drawable.clubs6))
    cardList.add(Card(5, R.drawable.clubs5))
    cardList.add(Card(4, R.drawable.clubs4))
    cardList.add(Card(3, R.drawable.clubs3))
    cardList.add(Card(2, R.drawable.clubs2))
    cardList.add(Card(14, R.drawable.diamonds_ace))
    cardList.add(Card(13, R.drawable.diamonds_king))
    cardList.add(Card(12, R.drawable.diamonds_queen))
    cardList.add(Card(11, R.drawable.diamonds_jack))
    cardList.add(Card(10, R.drawable.diamonds10))
    cardList.add(Card(9, R.drawable.diamonds9))
    cardList.add(Card(8, R.drawable.diamonds8))
    cardList.add(Card(7, R.drawable.diamonds7))
    cardList.add(Card(6, R.drawable.diamonds6))
    cardList.add(Card(5, R.drawable.diamonds5))
    cardList.add(Card(4, R.drawable.diamonds4))
    cardList.add(Card(3, R.drawable.diamonds3))
    cardList.add(Card(2, R.drawable.diamonds2))
    cardList.add(Card(14, R.drawable.spades_ace))
    cardList.add(Card(13, R.drawable.spades_king))
    cardList.add(Card(12, R.drawable.spades_queen))
    cardList.add(Card(11, R.drawable.spades_jack))
    cardList.add(Card(10, R.drawable.spades10))
    cardList.add(Card(9, R.drawable.spades9))
    cardList.add(Card(8, R.drawable.spades8))
    cardList.add(Card(7, R.drawable.spades7))
    cardList.add(Card(6, R.drawable.spades6))
    cardList.add(Card(5, R.drawable.spades5))
    cardList.add(Card(4, R.drawable.spades4))
    cardList.add(Card(3, R.drawable.spades3))
    cardList.add(Card(2, R.drawable.spades2))
    cardList.add(Card(14, R.drawable.hearts_ace))
    cardList.add(Card(13, R.drawable.hearts_king))
    cardList.add(Card(12, R.drawable.hearts_queen))
    cardList.add(Card(11, R.drawable.hearts_jack))
    cardList.add(Card(10, R.drawable.hearts10))
    cardList.add(Card(9, R.drawable.hearts9))
    cardList.add(Card(8, R.drawable.hearts8))
    cardList.add(Card(7, R.drawable.hearts7))
    cardList.add(Card(6, R.drawable.hearts6))
    cardList.add(Card(5, R.drawable.hearts5))
    cardList.add(Card(4, R.drawable.hearts4))
    cardList.add(Card(3, R.drawable.hearts3))
    cardList.add(Card(2, R.drawable.hearts2))
}

    fun getNewCard () : Card {

        if (cardList.size == 1) {
            cresteCards()
        }
        nextCard = cardList.removeAt(0)
        oldCard = cardList[0]
        return nextCard

    }


}


