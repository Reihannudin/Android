package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

//Extend ViewModel
class GameViewModel : ViewModel() {

//    add compainon object
    companion object{
//        Time when game is over
        private const val DONE = 0L
//        countDown time interval
        private const val ONE_SECOND = 1000L
//        Total time for a game
        private const val COUNTDOWN_TIME = 60000L
    }

    //    the countDown timer
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime

    // The String version of the current time
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    private val timer: CountDownTimer

    // The current word
    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    // The Hint for the current word
    val wordHintString = Transformations.map(word) { word ->
        val randomPosition = (1..word.length).random()
        "Current word has " + word.length + " letters" +
                "\nThe letter at position " + randomPosition + " is " +
                word.get(randomPosition - 1).toUpperCase()
    }


    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    // Event which triggers the end of the game
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        // Creates a timer which triggers the end of the game when it finishes
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND){
            override fun onTick(millisUntilFinished: Long){
                _currentTime.value = millisUntilFinished/ONE_SECOND

            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }
        timer.start()

        _word.value = ""
        _score.value = 0
        _word.value = wordHintString.toString()
        resetList()
        nextWord()
        Log.i("GameViewModel", "GameViewModel created!")
    }
    /**
     * Moves to the next word in the list
     */
    fun nextWord() {
        // Shuffle the word list, if the list is empty
        if (wordList.isEmpty()) {
            resetList()
        }else
        //Select and remove a word from the list
        _word.value = wordList.removeAt(0)

//        updateWordText()
//        updateScoreText()
    }
    /** Methods for buttons presses **/
    fun onSkip() {
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    /** Method for the game completed event **/
    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    // Observer for the Game finished event
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}