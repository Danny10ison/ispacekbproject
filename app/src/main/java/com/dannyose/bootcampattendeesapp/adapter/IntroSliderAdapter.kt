package com.dannyose.bootcampattendeesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dannyose.bootcampattendeesapp.R
import com.dannyose.bootcampattendeesapp.models.IntroMessageModel

class IntroSliderAdapter(
    private val introSlide: List<IntroMessageModel>
) : RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlide[position])
    }

    override fun getItemCount(): Int {
        return introSlide.size
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.text_title)
        private val textDescription = view.findViewById<TextView>(R.id.text_description)
        // private val imageIcon = view.findViewById<ImageView>(R.id.imageSlideIcon)


        fun bind(introSlide: IntroMessageModel) {
            textTitle.text = introSlide.title
            textDescription.text = introSlide.description
            //imageIcon.setImageResource(introSlide.icon)
        }


    }

}