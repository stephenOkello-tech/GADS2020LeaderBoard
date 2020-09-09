package com.comptechnoid.gads2020leaderboard.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.comptechnoid.gads2020leaderboard.R

import com.comptechnoid.gads2020leaderboard.ui.submission.SubmitActivity
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

    private lateinit var vPager : ViewPager
    private lateinit var pagerTabs : TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)


        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.app_name)

        pagerTabs = findViewById(R.id.pagerTabs)
        vPager = findViewById(R.id.vPager)

        pagerTabs!!.addTab(pagerTabs!!.newTab().setText(getString(R.string.learning_learders)))
        pagerTabs!!.addTab(pagerTabs!!.newTab().setText(getString(R.string.skill_iq_leaders)))

        val pagerAdapter  = PagerAdapter(supportFragmentManager,1)
        vPager.adapter = pagerAdapter

       vPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(pagerTabs))

        pagerTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    vPager.currentItem = tab.position
                }
            }

        })







    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.submit_project_btn -> {
                openSubmitProjectActivity()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openSubmitProjectActivity(){
        val intent = Intent(this, SubmitActivity::class.java)
        startActivity(intent)
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


