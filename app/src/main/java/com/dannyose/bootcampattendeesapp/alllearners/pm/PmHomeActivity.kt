package com.dannyose.bootcampattendeesapp.alllearners.pm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dannyose.bootcampattendeesapp.R
import com.dannyose.bootcampattendeesapp.adapter.AllLearnersAdapter
import com.dannyose.bootcampattendeesapp.alllearners.LearnerProfileActivity
import com.dannyose.bootcampattendeesapp.constants.Attendees
import com.dannyose.bootcampattendeesapp.models.AllLearnersDataModel

class PmHomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pm_home)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("PM Learners")

        recyclerView = findViewById(R.id.recycler_view_pm)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val learnersList = ArrayList<AllLearnersDataModel>()
        learnersList.add(
            AllLearnersDataModel(
                "Claudia","Mintogo",
                "claudiamintogo@gmail.com","Female",
                "Student","0269384159", "Awoshie" , Attendees.CLAUDIA
            )
        )

        learnersList.add(
            AllLearnersDataModel(
                "Albert","Osei","oseialbert072@gmail.com","Male",
                "Software developer","0542291420","Labadi", Attendees.ALBERT
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


                val intent = Intent(this@PmHomeActivity, LearnerProfileActivity::class.java)
                intent.putExtra("firstName",firstName)
                intent.putExtra("lastName",lastName)
                intent.putExtra("email",email)
                intent.putExtra("gender",gender)
                intent.putExtra("phone",phoneNumber)
                intent.putExtra("profession",profession)
                intent.putExtra("profileImage", learnerImage)
                intent.putExtra("PM","PM")
                startActivity(intent)
            }

        })

        recyclerView.adapter = learnersAdapter
    }
}