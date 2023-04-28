package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizapp.Adapter.ClickListener
import com.example.quizapp.Adapter.QuizTopicAdapter
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Database.QuizRoomDatabase
import com.example.quizapp.Model.QuizTopicModel
import com.example.quizapp.Repository.QuizRepository
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory
import com.example.quizapp.Views.SelectOption
import com.example.quizapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionDAO: QuestionDAO
    private val quizTopicModelList = mutableListOf<QuizTopicModel>()
    private lateinit var quizTopicAdapter: QuizTopicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProvider(this, quizViewModelFactory).get(QuizViewModel::class.java)

        quizViewModel.deleteAllQuestions()

        quizTopicData()
        setRecyclerView()
    }

    fun quizTopicData() {

        val quizTopicModel = QuizTopicModel(R.drawable.pic1, "Android")
        quizTopicModelList.add(quizTopicModel)
        val quizTopicModel1 = QuizTopicModel(R.drawable.pic2, "Java")
        quizTopicModelList.add(quizTopicModel1)
        val quizTopicModel2 = QuizTopicModel(R.drawable.pic3, "Kotlin")
        quizTopicModelList.add(quizTopicModel2)
        val quizTopicModel3 = QuizTopicModel(R.drawable.pic4, "Room DB")
        quizTopicModelList.add(quizTopicModel3)
        val quizTopicModel4 = QuizTopicModel(R.drawable.pic5, "MVVM")
        quizTopicModelList.add(quizTopicModel4)
        val quizTopicModel5 = QuizTopicModel(R.drawable.pic6, "Database")
        quizTopicModelList.add(quizTopicModel5)
        val quizTopicModel6 = QuizTopicModel(R.drawable.pic7, "Algorithms")
        quizTopicModelList.add(quizTopicModel6)
        val quizTopicModel7 = QuizTopicModel(R.drawable.pic8, "Android Jetpack")
        quizTopicModelList.add(quizTopicModel7)
        val quizTopicModel8 = QuizTopicModel(R.drawable.pic1, "Dependency Injection")
        quizTopicModelList.add(quizTopicModel8)
        val quizTopicModel9 = QuizTopicModel(R.drawable.pic2, "OOP")
        quizTopicModelList.add(quizTopicModel9)
        val quizTopicModel10 = QuizTopicModel(R.drawable.pic3, "Coroutines")
        quizTopicModelList.add(quizTopicModel10)
    }

    private fun setRecyclerView() {
        quizTopicAdapter = QuizTopicAdapter(this, quizTopicModelList, this)
        val layoutManager = GridLayoutManager(this,2)
        rcv.layoutManager = layoutManager
        rcv.adapter = quizTopicAdapter

    }

    override fun onStartQuiz(quizTopicModel: QuizTopicModel, position: Int) {
        val intent = Intent(this, SelectOption::class.java)
        intent.putExtra("TopicName", quizTopicModel.topicName)
        startActivity(intent)
    }
}