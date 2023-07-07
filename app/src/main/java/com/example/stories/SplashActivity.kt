package com.example.stories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        finishSplash()

    }

    private fun finishSplash() {
        //time for 3 sec then navigate to login
        Handler(Looper.myLooper()!!).postDelayed({
            finish() // to kill splash screen when back
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        },3000)
    }
}