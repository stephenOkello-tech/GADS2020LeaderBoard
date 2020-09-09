package com.comptechnoid.gads2020leaderboard.ui.submission

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.comptechnoid.gads2020leaderboard.R

class SubmitActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        supportActionBar!!.title = getString(R.string.gaads)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when(item.itemId){
                android.R.id.home -> {
                    finish()
                    return true
                }
                else -> {
                    return super.onOptionsItemSelected(item)
                }
            }
    }
}