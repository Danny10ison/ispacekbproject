package com.dannyose.bootcampattendeesapp.alllearners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.dannyose.bootcampattendeesapp.R

class LearnerProfileActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var fullnameField: TextView
    private lateinit var emailField : TextView
    private lateinit var phoneNumber: TextView
    private lateinit var genderField: TextView
    private lateinit var professionField: TextView
    private lateinit var imageBg: RelativeLayout
    private lateinit var imageProfileTwo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learner_profile)

        profileImage = findViewById(R.id.profile_image)
        fullnameField = findViewById(R.id.fullname_field)
        emailField = findViewById(R.id.email_field)
        phoneNumber = findViewById(R.id.phone_number)
        genderField = findViewById(R.id.gender_field)
        professionField = findViewById(R.id.profession_field)
        imageBg = findViewById(R.id.image_bg)
        imageProfileTwo = findViewById(R.id.profile_image_two)


        val intent = getIntent();
        val fName = intent.getStringExtra("firstName")
        val lName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val profession = intent.getStringExtra("profession")
        val phoneNumb = intent.getStringExtra("phone")
        val profileImg = intent.getIntExtra("profileImage",1)
        val pm: String? = intent.getStringExtra("PM")
        val am: String? = intent.getStringExtra("AM")
        if (pm.equals("PM")) {
            supportActionBar?.setTitle("PM $fName $lName")
        }else if(am.equals("AM")){
            supportActionBar?.setTitle("AM $fName $lName")
        }

        fullnameField.text = "$fName $lName"
        emailField.text = email
        genderField.text = gender
        professionField.text = profession
        profileImage.setImageResource(profileImg)
        imageProfileTwo.setImageResource(profileImg)

        imageBg.setBackgroundResource(profileImg)


        phoneNumber.text = phoneNumb
    }
}