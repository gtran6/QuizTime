package com.example.quizapp.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.Adapter.QuizTopicAdapter
import com.example.quizapp.Adapter.RecapAdapter
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Database.QuizRoomDatabase
import com.example.quizapp.MainActivity
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.R
import com.example.quizapp.Repository.QuizRepository
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory
import com.example.quizapp.databinding.ActivityRecapBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recap.*
import kotlinx.android.synthetic.main.activity_recap.rcv
import kotlinx.android.synthetic.main.item_answer.*

class RecapActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecapBinding
    private var questionModelList = mutableListOf<QuestionModel>()
    private var correctAnswers = mutableListOf<String>()
    private var userAnswers = mutableListOf<String>()
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionDAO: QuestionDAO
    private lateinit var recapAdapter: RecapAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val topicName: String = intent.getStringExtra("TopicName").toString()

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProvider(this, quizViewModelFactory).get(QuizViewModel::class.java)

        when (topicName) {
            "Android" -> {
                quizViewModel.getAndroidQuestions().observe(this, Observer {
                    questionModelList.addAll(it)
                    showResult()
                })
            }
            "Kotlin" -> {
                quizViewModel.getAndroidQuestions().observe(this, Observer {
                    questionModelList.addAll(it)
                    showResult()
                })
            }
            "Coroutines" -> {
                quizViewModel.getAndroidQuestions().observe(this, Observer {
                    questionModelList.addAll(it)
                    showResult()
                })
            }
            "MVVM" -> {
                quizViewModel.getAndroidQuestions().observe(this, Observer {
                    questionModelList.addAll(it)
                    showResult()
                })
            }
        }
    }

    private fun showResult() {
        for (i in 0 until questionModelList.size) {
            correctAnswers.add(questionModelList[i].answer.toString())
            userAnswers.add(intent.getStringExtra("userAnswer$i").toString())
        }

        var correctCount = 0
        var incorrectCount = 0

        for (i in 0 until questionModelList.size) {
            if (correctAnswers[i] == userAnswers[i]) {
                correctCount++
                addResultItem(true, questionModelList[i].question, correctAnswers[i], userAnswers[i])
            } else {
                incorrectCount++
                addResultItem(false, questionModelList[i].question, correctAnswers[i], userAnswers[i])
            }
        }

        val totalQuestions = questionModelList.size
        val correctPercentage = (correctCount * 100) / totalQuestions

        binding.apply {
            tv_total_question_result.text = "Quest. $totalQuestions"
            tv_correct_result.text = "Correct Answers: $correctCount"
            tv_wrong_result.text = "Incorrect Answers: $incorrectCount"
            tv_score_result.text = "Text Score: $correctCount"
        }

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun addResultItem(isCorrect: Boolean, question: String, correctAnswer: String, userAnswer: String) {
        val itemView = layoutInflater.inflate(R.layout.item_answer, null)
        itemView.apply {
            tv_question_answer.text = question
            tv_correct_answer.text = "Correct Answer: ${correctAnswer}"
            tv_user_answer.text = "Your Answer: ${userAnswer}"

            if (isCorrect) {
                tv_title_answer.text = "Answer is Correct"
            } else {
                tv_title_answer.text = "Answer is Incorrect"
            }
        }
        recapAdapter = RecapAdapter(questionModelList)
        val layoutManager = LinearLayoutManager(this)
        rcv.layoutManager = layoutManager
        rcv.adapter = recapAdapter
        rcv.addView(itemView)
    }
}