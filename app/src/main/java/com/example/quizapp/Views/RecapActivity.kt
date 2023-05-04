package com.example.quizapp.Views

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityRecapBinding

class RecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecapBinding
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

        binding.txtUserAnswer.text = selectedOption
    }
}