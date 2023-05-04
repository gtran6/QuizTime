package com.example.quizapp.Adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.Views.QuizActivity
import com.example.quizapp.Views.RecapActivity
import com.example.quizapp.databinding.ItemAnswerBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecapAdapter(private val list: List<QuestionModel>, private val context: Context) :
 RecyclerView.Adapter<RecapAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val gson = Gson()
        val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("questionList", null)

        val selectedOption = sharedPreferences.getString("selected_option", null)

        holder.binding.apply {
            tvTitleQuestion.text = gson.fromJson(json, object : TypeToken<List<QuestionModel>>() {}.type)
            tvUserAnswer.text = selectedOption
        }
    }
}