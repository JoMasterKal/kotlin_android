package com.our_world_tkpl.kotlin_android

import android.content.Context
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.our_world_tkpl.kotlin_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("jonathan KALONGA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        findViewById<Button>(R.id.done_btn).setOnClickListener {
//            addNickname(it)
//        }
        binding.myName = myName
        binding.doneBtn.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val editText = findViewById<EditText>(R.id.nickName_edit)
//        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        binding.apply {
//            nicknameText.text = binding.nickNameEdit.text
            myName?.nickname = nickNameEdit.text.toString()
            invalidateAll()
            nickNameEdit.visibility = View.GONE
            view.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        //hide a keyboad.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}