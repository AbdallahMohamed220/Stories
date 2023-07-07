package com.example.stories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import android.content.Context
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.constraintlayout.widget.ConstraintLayout

class LoginActivity : AppCompatActivity() {
  lateinit var loginLayout:ConstraintLayout
    lateinit var emailEditText: EditText
    lateinit var passwordEditText:EditText
    lateinit var loginButton: Button
    lateinit var imageViewToggle: ImageView

    private var isPasswordVisible = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        connectViews()
        login()

        imageViewToggle.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            updatePasswordVisibility()
        }
    }




    private fun connectViews() {
        emailEditText=findViewById(R.id.Ed_Email)
        passwordEditText=findViewById(R.id.Ed_Password)
        imageViewToggle=findViewById(R.id.imageViewToggle)
        loginButton=findViewById(R.id.login_button)
        loginLayout=findViewById(R.id.login_layout)
    }
    private fun checkFields():Boolean {
        if (emailEditText.text.isEmpty()){
            emailEditText.error="Enter Your Email"
            return false;
        }else if (passwordEditText.text.isEmpty()){
            passwordEditText.error="Enter Your Password"
            return false;

        }
        return true;

    }
    private fun login(){

        val users :ArrayList<User> =ArrayList()
        users.add(User("test@test.com","123456"))
        users.add(User("test1@test.com","123456"))
        users.add(User("test2@test.com","123456"))

        loginButton.setOnClickListener {
            if(checkFields()){
                val loginUser = User(emailEditText.text.toString(),passwordEditText.text.toString())
                for(user in users){
                    if(user.email==loginUser.email && user.password==loginUser.password){
                        finish()
                        val i = Intent(this,MainActivity::class.java)
                        i.putExtra("Em,ail",emailEditText.text.toString())
                        startActivity(i)
                        break
                    }else{
                        Toast.makeText(this,"please check your data ",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }
    private fun updatePasswordVisibility() {
        if (isPasswordVisible) {
            passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imageViewToggle.setImageResource(R.drawable.baseline_visibility_24)
        } else {
            passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
            imageViewToggle.setImageResource(R.drawable.baseline_visibility_off_24)
        }

        passwordEditText.setSelection(passwordEditText.text?.length ?: 0)
    }

}