package com.example.quizapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Model.QuestionModel
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
        holder.binding.apply {
            tvQuestionAnswer.text = list[position].question
        }
    }
}