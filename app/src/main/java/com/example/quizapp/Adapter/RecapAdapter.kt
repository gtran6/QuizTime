package com.example.quizapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.R

class RecapAdapter(
    private val questions: List<QuestionModel>,
    private val userAnswers: List<String>,
    private val correctAnswers: List<String>
) : RecyclerView.Adapter<RecapAdapter.RecapViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecapViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recap_item, parent, false)
        return RecapViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecapViewHolder, position: Int) {
        val question = questions[position]
        val userAnswer = userAnswers[position]
        val correctAnswer = correctAnswers[position]

        holder.bindData(question, userAnswer, correctAnswer)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    inner class RecapViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvQuestion: TextView = itemView.findViewById(R.id.tvQuestion)
        private val tvUserAnswer: TextView = itemView.findViewById(R.id.tvUserAnswer)
        private val tvCorrectAnswer: TextView = itemView.findViewById(R.id.tvCorrectAnswer)

        fun bindData(question: QuestionModel, userAnswer: String, correctAnswer: String) {
            tvQuestion.text = question.question
            tvUserAnswer.text = userAnswer
            tvCorrectAnswer.text = correctAnswer
        }
    }
}