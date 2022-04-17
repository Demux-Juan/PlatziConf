package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.platziconf.R
import com.example.platziconf.view.adapter.ScheduleAdapter
import com.example.platziconf.viewmodel.ScheduleViewModel

class ScheduleFragment : Fragment() {

    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel : ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//esto no coincide con el contenido de platzi porque se actualizó
        viewModel = ViewModelProvider(this)[ScheduleViewModel::class.java]
        viewModel.refresh()
        scheduleAdapter = ScheduleAdapter(this)


    }

}