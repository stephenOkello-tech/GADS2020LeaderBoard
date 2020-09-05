package com.comptechnoid.gads2020leaderboard

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.comptechnoid.gads2020leaderboard.ui.home.HomeActivity

class Del : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_del)
        showWelcomeScreen()
    }

    //briefly sgow the welcome screen
    private fun showWelcomeScreen() {
        val handler = Handler()
        handler.postDelayed({
            val goToHome = Intent(this@Del, HomeActivity::class.java)
            startActivity(goToHome)
            finish()
        }, 2000)
    }
}