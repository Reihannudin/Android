package google.codelab.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import google.codelab.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//defining the binding object
    private lateinit var binding : ActivityMainBinding

    private val myName: MyName = MyName("Reihannudin")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        make object binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        set the object to the binding object
        binding.myName = myName
//        with binding
        findViewById<Button>(R.id.done_button)
                binding.doneButton.setOnClickListener {
                    addNickname(it)
                }
//        with binding
        findViewById<View>(R.id.nickname_text)
        binding.nicknameText.setOnClickListener {
                    updateNickname(it)
                }

//        without binding
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
//
//        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
//            updateNickname(it)
//        }


    }

    private fun clickHandlerFunction(viewThatsClicked: View) {
        // Perform action on click
    }

    private fun addNickname(view: View) {

        binding.myName?.nickname = binding.nicknameEdit.text.toString()
        binding.invalidateAll()

        binding.nicknameEdit.visibility = View.GONE

        binding.doneButton.visibility = View.GONE

        binding.nicknameText.visibility = View.VISIBLE

        /*
        * Or can write like this
        * binding.apply {
        * nicknameText.text = nicknameEdit.text.toString()
        * nicknameEdit.visibility = View.GONE
        * doneButton.visibility = View.GONE
        * nicknameText.visibility = View.VISIBLE}
        * */


//        HIde keyword Input
// Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}