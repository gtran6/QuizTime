package com.example.quizapp.Adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.Views.QuizActivity
import com.example.quizapp.Views.RecapActivity
import com.example.quizapp.databinding.ItemAnswerBinding

class RecapAdapter(private val list: List<QuestionModel>) :
 RecyclerView.Adapter<RecapAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = holder.itemView.context as Activity
        val intent = Intent(activity, QuizActivity::class.java)
        val questions = intent.getStringExtra("question")
        holder.binding.apply {
            tvTitleQuestion.text = questions
        }
    }
}