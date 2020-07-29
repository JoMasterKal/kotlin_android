package com.our_world_tkpl.materialdesign

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        // Set an error if the password is less than 8 characters.
        view.next_button.setOnClickListener{
            if (!isPasswordValid(password_edit_text.text!!)) {
                password_text_input.error = getString(R.string.shr_error_password)
            } else {
                // Clear the error.
                password_text_input.error = null
                // Navigate to the next Fragment.
                (activity as NavigationHost).navigateTo(ProductGridFragment(), false)
            }
        }

        // Clear the error once more than 8 characters are typed.
        view.password_edit_text.setOnKeyListener { _, _, _ ->
            if (!isPasswordValid(password_edit_text.text!!)) {
                // Clear the error.
                password_text_input.error = null
            }
            false
        }
        return view
    }

    private fun isPasswordValid(text: Editable?): Boolean {
        return text != null && text.length >= 8
    }

}