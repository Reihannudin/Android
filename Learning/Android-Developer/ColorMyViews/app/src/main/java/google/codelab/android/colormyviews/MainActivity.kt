package google.codelab.android.colormyviews

import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var boxThreeText = findViewById<TextView>(R.id.box_three_text)
    private var boxFourText = findViewById<TextView>(R.id.box_four_text)
    private var boxFiveText = findViewById<TextView>(R.id.box_five_text)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    /**
     * Attaches listeners to all the views.
     */
    private fun setListeners() {

        val boxOneText = findViewById<TextView>(R.id.box_one_text)
        val boxTwoText = findViewById<TextView>(R.id.box_two_text)
        val boxThreeText = findViewById<TextView>(R.id.box_three_text)
        val boxFourText = findViewById<TextView>(R.id.box_four_text)
        val boxFiveText = findViewById<TextView>(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)


        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(
                boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton
            )

        for (item in clickableViews) {
            item.setOnClickListener { makeColored(it) }
        }
    }

    /**
     * Sets the background color of a view depending on it's resource id.
     * This is a way of using one click handler to do similar operations on a
     * group of views.
     */

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(GRAY)

            R.id.box_three_text -> view.setBackgroundColor(BLUE)
            R.id.box_four_text -> view.setBackgroundColor(MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(BLUE)

            // Boxes using custom colors for background
            R.id.red_button -> boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFiveText.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(LTGRAY)
        }
    }
}