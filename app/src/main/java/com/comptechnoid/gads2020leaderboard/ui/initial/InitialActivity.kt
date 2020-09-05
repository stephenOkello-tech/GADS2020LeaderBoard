package com.comptechnoid.gads2020leaderboard.ui.initial

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.StrictMode
import com.comptechnoid.gads2020leaderboard.BuildConfig

import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.service.LearningLeader
import com.comptechnoid.gads2020leaderboard.service.MainService
import com.comptechnoid.gads2020leaderboard.service.ServiceBuilder
import com.comptechnoid.gads2020leaderboard.service.Welcome
import com.comptechnoid.gads2020leaderboard.ui.home.HomeActivity
import com.comptechnoid.gads2020leaderboard.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InitialActivity : AppCompatActivity() {

    private val mainService : MainService = ServiceBuilder.buildService(com.comptechnoid.gads2020leaderboard.service.MainService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial)


        enableStrictMode()
        brieflyShowWelcomeScreen()
    }

    //Briefly show welcome screen then move to the home
    private fun brieflyShowWelcomeScreen(){
        val handler = Handler()
        handler.postDelayed({
            val home = Intent(this, HomeActivity::class.java)
            startActivity(home)
            finish()
        }, 2000)
    }

    private fun showWelcomeContent(){
        val requestCall : Call<Welcome> = mainService.welcome()
        requestCall.enqueue(object : Callback<Welcome>{
            override fun onFailure(call: Call<Welcome>, t: Throwable) {
                toast(t.message.toString())
            }

            override fun onResponse(call: Call<Welcome>, response: Response<Welcome>) {
                if(response.isSuccessful){
                    toast(response.body()?.name.toString())
                    toast(response.body()?.message.toString())
                }
            }
        })
    }

    private fun enableStrictMode() {
        if (BuildConfig.DEBUG) {
            val policy =
                StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog()
            StrictMode.setThreadPolicy(policy.build())
        }
    }

    //Check if the user is connected to internet

    private fun isConnected() : Boolean? {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork : NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting
    }



}
