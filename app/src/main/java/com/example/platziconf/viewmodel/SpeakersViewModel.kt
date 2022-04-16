package com.example.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.platziconf.model.Speaker
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreServices
import java.lang.Exception

class SpeakersViewModel {

    val firestoreService = FirestoreServices()
    var listSpeaker: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoding = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {

            override fun onSuccess(result: List<Speaker>?) {
                listSpeaker.postValue(result)
                processFinished()

            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }

        })

    }

    fun processFinished() {
        isLoding.value = true
    }
}