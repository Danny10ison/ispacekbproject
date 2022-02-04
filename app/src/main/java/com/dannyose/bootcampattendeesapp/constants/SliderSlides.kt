package com.dannyose.bootcampattendeesapp.constants

import com.dannyose.bootcampattendeesapp.adapter.IntroSliderAdapter
import com.dannyose.bootcampattendeesapp.models.IntroMessageModel

object SliderSlides {
    val introSliderAdapter = IntroSliderAdapter(
        listOf(
            IntroMessageModel(
                "Google StartUp",
                "Learn android development with Google ."
            ),
            IntroMessageModel(
                "Build project at The end of your learning",
                "Be selected to sit for the Examination."
            ),
            IntroMessageModel(
                "Pass the exam",
                "Build projects to be in demand in the job industry."
            )
        )
    )
}