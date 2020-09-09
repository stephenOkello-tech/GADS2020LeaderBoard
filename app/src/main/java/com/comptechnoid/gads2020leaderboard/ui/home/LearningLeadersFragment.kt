package com.comptechnoid.gads2020leaderboard.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.adapters.LearningLeadersAdapter
import com.comptechnoid.gads2020leaderboard.service.LearningLeader
import com.comptechnoid.gads2020leaderboard.service.MainService
import com.comptechnoid.gads2020leaderboard.service.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass.
 * Use the [LearningLeadersFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningLeadersFragment : Fragment() {

    private lateinit var learning_leaders_recyclerview : RecyclerView

    private val mainService = ServiceBuilder.buildService(MainService::class.java)
    private  lateinit var adapter : LearningLeadersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_learning_leaders, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        learning_leaders_recyclerview = view.findViewById<RecyclerView>(R.id.learning_leaders_recyclerview)
        learning_leaders_recyclerview.setHasFixedSize(true)
        learning_leaders_recyclerview.layoutManager = LinearLayoutManager(view.context)

        val requestCall : Call<List<LearningLeader>> = mainService.getLearningLeaders()
        requestCall.enqueue(object : Callback<List<LearningLeader>> {
            override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<LearningLeader>>,
                response: Response<List<LearningLeader>>
            ) {
                //hold.text = response.body().toString()
                adapter = LearningLeadersAdapter(targetFragment?.context, response.body())
                learning_leaders_recyclerview.adapter = adapter

            }

        })


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         */
        @JvmStatic
        fun newInstance() : Fragment {
            val fragment  = LearningLeadersFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    private val learningLeaders: Unit  get() {
        val requestCall : Call<List<LearningLeader>> = mainService.getLearningLeaders()
        requestCall.enqueue(object : Callback<List<LearningLeader>> {
            override fun onFailure(call: Call<List<LearningLeader>>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<List<LearningLeader>>,
                response: Response<List<LearningLeader>>
            ) {
                //hold.text = response.body().toString()
                adapter = LearningLeadersAdapter(targetFragment?.context, response.body())
            }

        })
    }
}
