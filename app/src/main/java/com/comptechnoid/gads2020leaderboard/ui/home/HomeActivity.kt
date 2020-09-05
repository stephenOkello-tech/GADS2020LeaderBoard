package com.comptechnoid.gads2020leaderboard.ui.home

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.service.LearningLeader
import com.comptechnoid.gads2020leaderboard.service.MainService
import com.comptechnoid.gads2020leaderboard.service.ServiceBuilder
import com.comptechnoid.gads2020leaderboard.utils.toast
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private val mainService = ServiceBuilder.buildService(MainService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val hold : TextView = findViewById<TextView>(R.id.hold) as TextView



        learningLeaders
    }

    private val learningLeaders: Unit private get() {
        val requestCall : Call<List<LearningLeader>> = mainService.getLearningLeaders()
        requestCall.enqueue(object : Callback<List<LearningLeader>>{
            override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
                toast(t.message.toString())
            }

            override fun onResponse(
                call: Call<List<LearningLeader>>,
                response: Response<List<LearningLeader>>
            ) {
                toast(response.body().toString())
                hold.text = response.body().toString()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}


