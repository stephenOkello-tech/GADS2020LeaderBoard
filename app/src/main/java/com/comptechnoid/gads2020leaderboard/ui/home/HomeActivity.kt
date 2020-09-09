package com.comptechnoid.gads2020leaderboard.ui.home

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.service.LearningLeader
import com.comptechnoid.gads2020leaderboard.service.MainService
import com.comptechnoid.gads2020leaderboard.service.ServiceBuilder
import com.comptechnoid.gads2020leaderboard.utils.toast
import com.google.android.material.tabs.TabLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private val mainService = ServiceBuilder.buildService(MainService::class.java)
    private lateinit var vPager : ViewPager
    private lateinit var pagerTabs : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)


        vPager = findViewById(R.id.vPager)
        pagerTabs = findViewById(R.id.pagerTabs)

        val pagerAdapter  = PagerAdapter(supportFragmentManager,1)
        vPager.adapter = pagerAdapter

       vPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(pagerTabs))





        //learningLeaders
    }

    private val learningLeaders: Unit  get() {
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
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    class PagerAdapter(fm : FragmentManager, behavior : Int) : FragmentPagerAdapter(fm,behavior) {
        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return LearningLeadersFragment.newInstance()
                1 -> return SkillIQLeadersFragment.newInstance()
                else -> return SkillIQLeadersFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 2
        }


    }

}


