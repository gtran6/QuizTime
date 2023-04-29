package com.example.quizapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.quizapp.Model.QuizTopicModel
import com.example.quizapp.R
import com.example.quizapp.databinding.QuizTopicLayoutBinding

class QuizTopicAdapter(
    val context: Context,
    val list: MutableList<QuizTopicModel>,
    private val clickListener: ClickListener
) : RecyclerView.Adapter<QuizTopicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizTopicViewHolder {
        return QuizTopicViewHolder(QuizTopicLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: QuizTopicViewHolder, position: Int) {
        val quizTopicModel = list[position]

        holder.binding.apply {
            tvTopicName.text = quizTopicModel.topicName
            Glide.with(holder.itemView).load(quizTopicModel.iconID).into(holder.binding.ivTopicIcon)

            layout.setOnClickListener {
                clickListener.onStartQuiz(quizTopicModel, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class QuizTopicViewHolder(val binding: QuizTopicLayoutBinding) : RecyclerView.ViewHolder(binding.root)