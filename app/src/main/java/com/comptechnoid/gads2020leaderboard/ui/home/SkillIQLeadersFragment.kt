package com.comptechnoid.gads2020leaderboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.adapters.SkillIQAdapter
import com.comptechnoid.gads2020leaderboard.service.MainService
import com.comptechnoid.gads2020leaderboard.service.ServiceBuilder
import com.comptechnoid.gads2020leaderboard.service.SkillIQLeader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [SkillIQLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SkillIQLeadersFragment : Fragment() {

    private lateinit var skilliqrecyclerview : RecyclerView
    private val mainService = ServiceBuilder.buildService(MainService::class.java)

    private lateinit var adapter : SkillIQAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skill_i_q_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        skilliqrecyclerview = view.findViewById(R.id.skilliqRV)
        skilliqrecyclerview.setHasFixedSize(true)
        skilliqrecyclerview.layoutManager = LinearLayoutManager(view.context)

        val requestCall = mainService.getSkilliqLeaders()
        requestCall.enqueue(object : Callback<List<SkillIQLeader>>{
            override fun onFailure(call: Call<List<SkillIQLeader>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<SkillIQLeader>>,
                response: Response<List<SkillIQLeader>>
            ) {
                if(response.body() != null){
                    adapter = SkillIQAdapter(response.body()!!)
                    skilliqrecyclerview.adapter = adapter
                }
            }

        })

    }

    companion object {

        @JvmStatic
        fun newInstance() : Fragment{
            return SkillIQLeadersFragment()
        }

    }
}
