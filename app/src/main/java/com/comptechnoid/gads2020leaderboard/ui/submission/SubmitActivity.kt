package com.comptechnoid.gads2020leaderboard.ui.submission

import android.content.DialogInterface
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.service.SubmitService
import com.comptechnoid.gads2020leaderboard.service.SubmitServiceBuilder
import com.comptechnoid.gads2020leaderboard.utils.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null

    private lateinit var firstname : TextView
    private lateinit var lastname : TextView
    private lateinit var email : TextView
    private lateinit var git_url : TextView
    private lateinit var submit_btn : Button

    private val submitService = SubmitServiceBuilder.buildService(SubmitService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submit)

        init()

        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        supportActionBar!!.title = getString(R.string.gaads)


        submit_btn.setOnClickListener{
            val requestCall = submitService.submitProject(
                firstname.text.toString(),
                lastname.text.toString(),
                email.text.toString(),
                git_url.text.toString()
            )

            requestCall.enqueue(object : Callback<Void>{
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    toast(t.message.toString())
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if(response.isSuccessful){
                        toast("Submission Sucessful")
                    }else{
                        toast("Submission not Succesful")
                    }
                }

            })

        }


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


    private fun init(){
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        firstname = findViewById(R.id.first_name)
        lastname = findViewById(R.id.last_name)
        email = findViewById(R.id.email_address)
        git_url = findViewById(R.id.git_url)
        submit_btn = findViewById(R.id.submit_btn)
    }



}

