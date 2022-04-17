package com.example.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.platziconf.model.Conference
import com.example.platziconf.network.Callback
import com.example.platziconf.network.FirestoreServices
import java.lang.Exception

class ScheduleViewModel: ViewModel() {
    //se crea una instancia u objeto llamado firestoreService
    val firestoreService = FirestoreServices()
    var listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    var isLoding = MutableLiveData<Boolean>()

    fun refresh() {
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase() {
        firestoreService.getSchedule(object : Callback<List<Conference>> {

            override fun onSuccess(result: List<Conference>?) {
                listSchedule.postValue(result)
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