package com.dannyose.bootcampattendeesapp.alllearners.am

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dannyose.bootcampattendeesapp.R
import com.dannyose.bootcampattendeesapp.adapter.AllLearnersAdapter
import com.dannyose.bootcampattendeesapp.alllearners.LearnerProfileActivity
import com.dannyose.bootcampattendeesapp.constants.Attendees
import com.dannyose.bootcampattendeesapp.models.AllLearnersDataModel

class AmHomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_am_home)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("AM Learners")

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val learnersList = ArrayList<AllLearnersDataModel>()
        learnersList.add(
            AllLearnersDataModel(
                "KWADWO","Busumtwi","kwadwobusumtwi@gmail.com","Male",
                "Backend Developer","0545644173","Accra", Attendees.KWADWO
            )
        )

//        learnersList.add(
//            AllLearnersDataModel(
//                "Olorunfemi","Oyewole","eliasikechi14@gmail.com","Male",
//                "Programmer/Graphic Designer","0545565901","Accra", Attendees.FEMI
//            )
//        )

        learnersList.add(
            AllLearnersDataModel(
                "Hephzibah","Emereole","hephzibahemereole@gmail.com","Female",
                "Student","0279542753","Berekuso", Attendees.ZIBAH
            )
        )

        learnersList.add(
            AllLearnersDataModel(
                "Fatimah ","Adam","adamfatima2557@gmail.com","Female",
                "Student of the  University for development Studies(UDS)","0201112557","Tema", Attendees.FATIMAH
            )
        )

        val learnersAdapter = AllLearnersAdapter(this,learnersList,object :AllLearnersAdapter.HandleLearnerClick{
            override fun onLearnerClick(position: Int) {
                val allLearners = learnersList[position]
                val firstName: String = allLearners.firstName
                val lastName: String = allLearners.lastName
                val email: String = allLearners.email
                val gender: String = allLearners.gender
                val profession :String = allLearners.profession
                val learnerImage :Int = allLearners.profileImage
                val phoneNumber: String = allLearners.phoneNumber


                val intent = Intent(this@AmHomeActivity, LearnerProfileActivity::class.java)
                intent.putExtra("firstName",firstName)
                intent.putExtra("lastName",lastName)
                intent.putExtra("email",email)
                intent.putExtra("gender",gender)
                intent.putExtra("profession",profession)
                intent.putExtra("phone",phoneNumber)
                intent.putExtra("profileImage", learnerImage)
                intent.putExtra("AM","AM")
                startActivity(intent)
            }

        })

        recyclerView.adapter = learnersAdapter

    }
}