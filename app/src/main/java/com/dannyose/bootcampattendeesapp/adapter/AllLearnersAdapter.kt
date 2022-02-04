package com.dannyose.bootcampattendeesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dannyose.bootcampattendeesapp.R
import com.dannyose.bootcampattendeesapp.models.AllLearnersDataModel

class AllLearnersAdapter(
    private val context: Context,
    private val learnersList: List<AllLearnersDataModel>,
    private val handleLearnerClick: HandleLearnerClick
): RecyclerView.Adapter<AllLearnersAdapter.AllLearnersViewHolder>() {

    interface HandleLearnerClick{
        fun onLearnerClick(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AllLearnersViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.learner_row_data,parent,false)
        return  AllLearnersViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: AllLearnersViewHolder, position: Int) {
        val dataPosition = learnersList[position]

        holder.firstName.text = dataPosition.firstName
        holder.learnerClick.setOnClickListener {
            handleLearnerClick.onLearnerClick(position)
        }

        Glide
            .with(context)
            .load(dataPosition.profileImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageUrl)
    }

    override fun getItemCount(): Int {
        return learnersList.size

    }

    class AllLearnersViewHolder(LearnerView: View):RecyclerView.ViewHolder(LearnerView) {
        val imageUrl: ImageView = LearnerView.findViewById(R.id.image_view)
        val firstName: TextView = LearnerView.findViewById(R.id.text_view)
        val learnerClick: CardView = LearnerView.findViewById(R.id.relative_layout)
    }
}