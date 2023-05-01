package com.example.quizapp.Views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Database.QuizRoomDatabase
import com.example.quizapp.MainActivity
import com.example.quizapp.Repository.QuizRepository
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory
import com.example.quizapp.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionDAO: QuestionDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProvider(this, quizViewModelFactory).get(QuizViewModel::class.java)

        quizViewModel.deleteAllQuestions()

        val score = intent.getIntExtra("correct", 0)
        val wrong = intent.getIntExtra("wrong", 0)

        tvCorrectAns.text = "Correct Answers - $score / $wrong"
        tvPointsEarned.text = "You Earned $score Points"

        btnDone.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnRecap.setOnClickListener {
            startActivity(Intent(this, RecapActivity::class.java))
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}