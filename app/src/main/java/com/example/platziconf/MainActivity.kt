package com.example.platziconf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.platziconf.model.Conference
import com.example.platziconf.model.Speaker
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Hola mundo")
        analytics.logEvent("InitScreen",bundle)


        val jsonArr = JSONArray(
            "[\n" +
                    "  {\n" +
                    "    'name': 'Juan mendoza', \n" +
                    "    'biography': '##### Biografia 1 #####', \n" +
                    "    'category': 1, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/aYaH1', \n" +
                    "    'jobtitle' : '##### jobtitle 1 #####', \n " +
                    "    'twitter' : '##### Twitter 1 #####', \n " +
                    "    'workplace' : '##### Workplace 1 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Brenda jimenez', \n" +
                    "    'biography': '##### Biografia 2 #####', \n" +
                    "    'category': 2, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/TLAjT', \n" +
                    "    'jobtitle' : '##### jobtitle 2 #####', \n " +
                    "    'twitter' : '##### Twitter 2 #####', \n " +
                    "    'workplace' : '##### Workplace 2 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Mariel Mendoza', \n" +
                    "    'biography': '##### Biografia 3 #####', \n" +
                    "    'category': 3, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/TFndD', \n" +
                    "    'jobtitle' : '##### jobtitle 3 #####', \n " +
                    "    'twitter' : '##### Twitter 3 #####', \n " +
                    "    'workplace' : '##### Workplace 3 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Aaron Nolasco', \n" +
                    "    'biography': '##### Biografia 4 #####', \n" +
                    "    'category': 4, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/c3Xo', \n" +
                    "    'jobtitle' : '##### jobtitle 4 #####', \n " +
                    "    'twitter' : '##### Twitter 4 #####', \n " +
                    "    'workplace' : '##### Workplace 4 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Beto Lopez', \n" +
                    "    'biography': '##### Biografia 5 #####', \n" +
                    "    'category': 5, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/cnxQ', \n" +
                    "    'jobtitle' : '##### jobtitle 5 #####', \n " +
                    "    'twitter' : '##### Twitter 5 #####', \n " +
                    "    'workplace' : '##### Workplace 5 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Tony Asevedo', \n" +
                    "    'biography': '##### Biografia 6 #####', \n" +
                    "    'category': 6, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/cKli', \n" +
                    "    'jobtitle' : '##### jobtitle 6 #####', \n " +
                    "    'twitter' : '##### Twitter 6 #####', \n " +
                    "    'workplace' : '##### Workplace 6 #####'\n" +
                    " },\n " +
                    "  {\n" +
                    "    'name': 'Rodrigo Salido', \n" +
                    "    'biography': '##### Biografia 7 #####', \n" +
                    "    'category': 7, \n" +
                    "    'image' : 'https://www.imagehousing.com/image/lqim', \n" +
                    "    'jobtitle' : '##### jobtitle 7 #####', \n " +
                    "    'twitter' : '##### Twitter 7 #####', \n " +
                    "    'workplace' : '##### Workplace 7 #####'\n" +

                    " }\n" +
                    " ]"
        )


        val jsonArr2 = JSONArray(
            "[\n" +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 1 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 1 ***\", \n" +
                    "    \"tag\" : \"tag1\", \n " +
                    "    \"title\" : \"*** Titutlo 1 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 2 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 2 ***\", \n" +
                    "    \"tag\" : \"tag2\", \n " +
                    "    \"title\" : \"*** Titutlo 1 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 3 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 3 ***\", \n" +
                    "    \"tag\" : \"tag3\", \n " +
                    "    \"title\" : \"*** Titutlo 3 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 4 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 4 ***\", \n" +
                    "    \"tag\" : \"tag1\", \n " +
                    "    \"title\" : \"*** Titutlo 4 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 5 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 5 ***\", \n" +
                    "    \"tag\" : \"tag2\", \n " +
                    "    \"title\" : \"*** Titutlo 5 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 6 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 6 ***\", \n" +
                    "    \"tag\" : \"tag3\", \n " +
                    "    \"title\" : \"*** Titutlo 6 **\" \n " +
                    " },\n " +
                    "  {\n" +
                    "    \"datetime\": 1564809000, \n" +
                    "    \"description\": \" *** Descripcion 7 ***\", \n" +
                    "    \"speaker\" : \"*** Speaker 7 ***\", \n" +
                    "    \"tag\" : \"tag4\", \n " +
                    "    \"title\" : \"*** Titutlo 7 **\" \n " +
                    " }\n" +
                    " ]"
        )


       val firebaseFirestore = FirebaseFirestore.getInstance()


        for (i in 0 until jsonArr.length()) {
            val aux = jsonArr.get(i) as JSONObject
            //hace referencia a la clase Speaker
            var speaker = Speaker()
            speaker.name = aux.getString("name")
            speaker.jobtitle = aux.getString("jobtitle")
            speaker.workplace = aux.getString("workplace")
            speaker.biography = aux.getString("biography")
            speaker.twitter = aux.getString("twitter")
            speaker.image = aux.getString("image")
            speaker.category = aux.getInt("category")

            firebaseFirestore.collection("speakers").document().set(speaker)

        }

        for (i in 0 until jsonArr2.length()) {
            val aux = jsonArr2.get(i) as JSONObject
            //hace referencia a la clase Conference
            var conference = Conference()

            val calendario = Calendar.getInstance()
            calendario.timeInMillis = aux.getLong("datetime") * 1000
            conference.datetime = calendario.time

            conference.description = aux.getString("description")
            conference.tag = aux.getString("tag")
            conference.title = aux.getString("title")
            conference.speaker = aux.getString("speaker")


            firebaseFirestore.collection("conferences").document().set(conference)


        }










    }
}