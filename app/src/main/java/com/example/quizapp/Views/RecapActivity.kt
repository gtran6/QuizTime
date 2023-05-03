package com.example.quizapp.Views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionDAO: QuestionDAO
    private lateinit var recapAdapter: RecapAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProvider(this, quizViewModelFactory).get(QuizViewModel::class.java)

        val score = intent.getIntExtra("correct", 0)
        val wrong = intent.getIntExtra("wrong", 0)
        val question = intent.getParcelableArrayExtra("question")

        tv_correct_result.text = "Correct ${score}"
        tv_wrong_result.text = "Incorrect ${wrong}"
        tv_score_result.text = "Text Score ${score}"

        setRecyclerView()
    }

    private fun setRecyclerView() {
        recapAdapter = RecapAdapter(questionModelList)
        val layoutManager = LinearLayoutManager(this)
        rcv.layoutManager = layoutManager
        rcv.adapter = recapAdapter
    }
}