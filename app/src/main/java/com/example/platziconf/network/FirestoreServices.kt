package com.example.platziconf.network

import com.example.platziconf.model.Conference
import com.example.platziconf.model.Speaker
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import java.util.*


const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"


class FirestoreServices {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        //se van a almacenar los datos offline
        firebaseFirestore.firestoreSettings = settings

    }

    //funcion que obtiene datos de la colleccion de speakers
    fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME).orderBy("category").get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }

    }

    //funcion que obtiene datos de la colleccion conferencias de firestore
    fun getSchedule(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME).get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Conference::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}