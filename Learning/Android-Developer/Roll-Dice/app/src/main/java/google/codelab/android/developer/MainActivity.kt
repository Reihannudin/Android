package google.codelab.android.developer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var diceImage1: ImageView
    lateinit var diceImage2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //         add valRollButton and get view by id from broo_uttohn
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { rollClear() }


//        add count_up_button
/*
        val countUpButton: Button = findViewById(R.id.roll_count_up)
        countUpButton.setOnClickListener {
            countUp()
        }

        val resetButton: Button = findViewById(R.id.roll_reset)
        resetButton.setOnClickListener {
            reset()
        }
*/


        //        get resultText
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = "Dice Rolled!"
    }

    //         make function rollDice
    private fun rollDice() {
        diceImage1.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())

//      make toast Untuk membuat toast, panggil Toast.makeText()
        Toast.makeText(this, "button roll has clicked", Toast.LENGTH_SHORT).show()
    }

    private fun rollClear(){
        diceImage1.setImageResource(getClearDiceImage())
        diceImage2.setImageResource(getClearDiceImage())

        Toast.makeText(this, "button clear has clicked", Toast.LENGTH_SHORT).show()

    }

    private fun getClearDiceImage(): Int {
        val rangeNumber = (1..6).random()
        return when (rangeNumber) {
            rangeNumber -> R.drawable.empty_dice
            else -> R.drawable.empty_dice

        }
    }

    private fun getRandomDiceImage() : Int {
        val randomNumber = (1..6).random()
//         make TextView
//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomNumber.toString()

        return when (randomNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
    }


    /*

//  * Click listener for the countUp button.
    private fun countUp() {
    val resultText: TextView = findViewById(R.id.result_text)
    // If text is the default "Hello World!" set that text to 1.
    if (resultText.text == "Hello World!") {
        resultText.text = "1"
    } else {
        // Otherwise, increment the number up to 6.
        // The text value in resultText.text is an instance of the CharSequence class;
        // it needs to be converted to a String object before it can be converted to an int.
        val resultInt = resultText.text.toString().toInt()

        if (resultInt < 6) {
            resultText.text = (resultInt + 1).toString()
        }
    }
}

    private fun reset(){
        val resultText: TextView = findViewById(R.id.result_text)
        val resultNumber = resultText.text.toString().toInt()
        val resultInt : Int = 0
        if(resultNumber >= resultInt){
            resultText.text = "0"
        } else {
            resultText.text = "0"
//        if (resultText.text  resultInt.toString()){
//            resultText.text = "0"
//        }


        }
    }
*/

