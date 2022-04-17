package com.example.platziconf.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import com.example.platziconf.view.adapter.SpeakerAdapter
import com.example.platziconf.view.adapter.SpeakerListener
import com.example.platziconf.viewmodel.SpeakersViewModel
import kotlinx.android.synthetic.main.fragment_speakers.*


class SpeakersFragment : Fragment(), SpeakerListener {

    private lateinit var speakerAdapter: SpeakerAdapter
    private lateinit var viewModel : SpeakersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_speakers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SpeakersViewModel::class.java)
        viewModel.refresh()
        speakerAdapter = SpeakerAdapter(this)


        rvSpeakers.apply{
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,false)
            adapter = speakerAdapter
        }


        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.listSpeaker.observe(viewLifecycleOwner, Observer<List<Speaker>>{
                speaker -> speakerAdapter.updateDate(speaker)
        })

        viewModel.isLoding.observe(viewLifecycleOwner,Observer<Boolean>{
            if(it != null)
                rlBaseSpeaker.visibility = View.INVISIBLE

        })
    }




    override fun onSpeakerClicked(speaker: Speaker, position: Int) {
        val bundle = bundleOf("speaker" to speaker)
        findNavController().navigate(R.id.scheduleDetailFragmentDialog,bundle)

    }

}