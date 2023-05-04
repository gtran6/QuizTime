package com.example.quizapp.Views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.Adapter.RecapAdapter
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.databinding.ActivityRecapBinding

class RecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecapBinding
    private lateinit var recapAdapter: RecapAdapter
    private lateinit var questionModel: QuestionModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecap()
    }

    private fun setUpRecap() {
        val question = intent.getStringExtra("question")
        binding.txtQuestion.text = question

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val selectedOption = sharedPreferences.getString("selected_option", null)
        val correctOption = sharedPreferences.getString("correct_option", null)

        binding.txtUserAnswer.text = "Your Answer Is $selectedOption"
        binding.txtCorrectAnswer.text = "Correct Answer Is $correctOption"
    }
}