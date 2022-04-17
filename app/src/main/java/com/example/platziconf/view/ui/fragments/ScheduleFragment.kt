package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziconf.R
import com.example.platziconf.model.Conference
import com.example.platziconf.view.adapter.ScheduleAdapter
import com.example.platziconf.view.adapter.ScheduleListener
import com.example.platziconf.viewmodel.ScheduleViewModel
import kotlinx.android.synthetic.main.fragment_schedule.*


class ScheduleFragment : Fragment(), ScheduleListener {

    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel : ScheduleViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//esto no coincide con el contenido de platzi porque se actualizó
        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()
        scheduleAdapter = ScheduleAdapter(this)

        //falta
        rvSchedule.apply{
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
            adapter = scheduleAdapter
        }


        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.listSchedule.observe(viewLifecycleOwner, Observer<List<Conference>>{
            schedule -> scheduleAdapter.updateDate(schedule)
        })

        viewModel.isLoding.observe(viewLifecycleOwner,Observer<Boolean>{
            if(it != null)
                rlBaseSchedule.visibility = View.INVISIBLE

        })
    }




    override fun onConferenceClicked(conference: Conference, position: Int) {
        TODO("Not yet implemented")
    }

}