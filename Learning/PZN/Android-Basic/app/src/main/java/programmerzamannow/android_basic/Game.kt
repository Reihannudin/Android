package programmerzamannow.android_basic

import kotlin.random.Random

object Game {
//     make rules data in map collection
    private val rules = mapOf(
    "ROCK-SCISSORS" to true,
    "SCISSORS-PAPER" to true,
    "PAPER-ROCK" to true,
    "ROCK-PAPER" to false,
    "SCISSORS-ROCK" to false,
    "PAPER-SCISSORS" to false
    )

//    define data rock, paper, scissors
    private val options = listOf("ROCK", "PAPER", "SCISSORS")

//    get image from drawable folder
    private val optionsImages = mapOf(
        "ROCK" to R.drawable.rock,
        "PAPER" to R.drawable.paper,
        "SCISSORS" to R.drawable.scissors
    )

//     make pick random option
    fun pickRandomOption(): String = options[Random.nextInt(0,3)]

//     make image from optionImages
    fun pickDrawable(options: String): Int = optionsImages[options]!!

//    make logic function if Draw
    fun isDraw(from: String, to : String ): Boolean = from == to

//    make logic if win and get data rules from map collection
    fun isWin(from: String, to : String ): Boolean = rules["$from-$to"]!!
}