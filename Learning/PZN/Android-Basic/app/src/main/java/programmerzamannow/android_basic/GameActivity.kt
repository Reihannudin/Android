package programmerzamannow.android_basic

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// make compp
class GameActivity : AppCompatActivity() {
//     add component from layout game.xml
    lateinit var computerImageView: ImageView
    lateinit var rockImageButton: ImageButton
    lateinit var paperImageButton: ImageButton
    lateinit var scissorsImageButton: ImageButton
    lateinit var resultImageView: ImageView

    // add variable from layout game.xml
    private fun initComponent(){
        computerImageView = findViewById(R.id.computerImageView)
        rockImageButton = findViewById(R.id.rockImageButton)
        paperImageButton = findViewById(R.id.paperImageButton)
        scissorsImageButton = findViewById(R.id.scissorsImageButton)
        resultImageView = findViewById(R.id.resultImageView)
    }

//    make function intListener
    private fun initListener(){
        rockImageButton.setOnClickListener {
            startGame("ROCK")
        }
        paperImageButton.setOnClickListener {
            startGame("PAPER")
        }
        scissorsImageButton.setOnClickListener {
            startGame("SCISSORS")
        }
    }

//    make function and startGame with parameter choice
    private fun startGame(choice: String){
        val computerOption = Game.pickRandomOption()
        computerImageView.setImageResource(Game.pickDrawable(computerOption))

    // validation compare
        when{
            Game.isDraw(choice, computerOption) ->
                resultImageView.setImageResource(R.drawable.draw)
            Game.isWin(choice, computerOption) ->
                resultImageView.setImageResource(R.drawable.win)
            else ->
                resultImageView.setImageResource(R.drawable.lose)
        }
    }


//    make fun onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        make setContentView
        setContentView(R.layout.game)

//     call initcomponent
        initComponent()
//     call initListener
        initListener()
    }

}
