package com.example.quizapp.Views

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Database.QuizRoomDatabase
import com.example.quizapp.Model.AndroidQuestionModel
import com.example.quizapp.MusicController.PlaySound
import com.example.quizapp.MusicController.TimerDialog
import com.example.quizapp.R
import com.example.quizapp.Repository.QuizRepository
import com.example.quizapp.Utils.InsertAndroidQuestions
import com.example.quizapp.Utils.InsertCoroutinesQuestions
import com.example.quizapp.Utils.InsertKotlinQuestions
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private var questionModelList = mutableListOf<AndroidQuestionModel>()
    private lateinit var quizRoomDatabase: QuizRoomDatabase
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var androidQuestionModel: AndroidQuestionModel
    private lateinit var questionDAO: QuestionDAO

    private var questionCount: Int = 0
    private var questionCounter: Int = 0
    private var scoreCount: Int = 0
    private var correct: Int = 0
    private var wrong: Int = 0
    private lateinit var correctAnimation: Animation
    private lateinit var wrongAnimation: Animation

    private var questionTotal: Int = 0

    var MUSIC_FLAG = 0
    private lateinit var timerDialog: TimerDialog
    private lateinit var playSound: PlaySound

    private var isAnswered: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        supportActionBar?.hide()

        var intent = Intent()
        intent = getIntent()
        val topicName: String = intent.getStringExtra("TopicName").toString()

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProviders.of(this, quizViewModelFactory).get(QuizViewModel::class.java)

        playSound = PlaySound(this)
        wrongAnimation = AnimationUtils.loadAnimation(this, R.anim.incorrect_animation)
        wrongAnimation.repeatCount = 3

        correctAnimation = AnimationUtils.loadAnimation(this, R.anim.right_ans_animation)
        correctAnimation.repeatCount = 3

        val insertQuestions = InsertAndroidQuestions()
        val kotlinQuestions = InsertKotlinQuestions()
        val coroutinesQuestions = InsertCoroutinesQuestions()

        if (topicName == "Android") {

            for (i in 0..insertQuestions.insertQuestionToDB().size) {
                quizViewModel.addQuestionData(insertQuestions.insertQuestionToDB()[i])
            }
        } else if (topicName == "Kotlin") {

            for (i in 0..kotlinQuestions.insertKotlinQuestionToDB().size) {
                quizViewModel.addQuestionData(kotlinQuestions.insertKotlinQuestionToDB()[i])
            }
        } else if (topicName == "Coroutines") {

            for (i in 0..coroutinesQuestions.insertCoroutinesQuestion().size) {
                quizViewModel.addQuestionData(coroutinesQuestions.insertCoroutinesQuestion()[i])
            }
        }

        quizViewModel.getAndroidQuestions().observe(this, Observer {
            questionModelList.clear()
            questionModelList.addAll(it)
            questionCount = questionModelList.size
            questionModelList.shuffle()
            moveToNextQuestion()
        })


        btnConfirm.setOnClickListener {
            if (!isAnswered) {
                if (radio_button1.isChecked || radio_button2.isChecked || radio_button3.isChecked) {
                    checkAnswerIsCorrectORNot()
                } else {
                    Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
            } else {
                moveToNextQuestion()
            }
        }
    }

    private fun moveToNextQuestion() {
        var intent = Intent()
        intent = getIntent()
        val topicName: String = intent.getStringExtra("TopicName").toString()

        questionTotal++

        tvTotalQuestions.text = "$questionTotal / ${questionModelList.size}"

        radio_group.clearCheck()
        radio_button1.setTextColor(Color.BLACK)
        radio_button2.setTextColor(Color.BLACK)
        radio_button3.setTextColor(Color.BLACK)

        radio_button1.setBackgroundColor(Color.TRANSPARENT)
        radio_button2.setBackgroundColor(Color.TRANSPARENT)
        radio_button3.setBackgroundColor(Color.TRANSPARENT)

        if (topicName.equals("Android") || topicName.equals("Kotlin") || topicName.equals("Coroutines")) {
            if (questionCounter < questionCount) {
                androidQuestionModel = questionModelList[questionCounter]
                tvQuestion.text = androidQuestionModel.question
                radio_button1.text = androidQuestionModel.option1
                radio_button2.text = androidQuestionModel.option2
                radio_button3.text = androidQuestionModel.option3
                questionCounter++;
                isAnswered = false;

            } else {
                quizEnded()
            }
        } else {
            layoutMain.visibility = View.GONE
        }
    }

    private fun quizEnded() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("correct", correct)
        intent.putExtra("wrong", wrong)

        startActivity(intent)

    }

    private fun checkAnswerIsCorrectORNot() {

        isAnswered = true
        val rbSelected: RadioButton = findViewById(radio_group.checkedRadioButtonId)
        var ansPosition = radio_group.indexOfChild(rbSelected) + 1

        if (ansPosition == androidQuestionModel.answer) {
            MUSIC_FLAG = 1
            rbSelected.setBackgroundResource(R.drawable.correct_ans_bg)
            playSound.seAudioforAnswers(MUSIC_FLAG)
            rbSelected.startAnimation(correctAnimation)
            correct++
            tvCorrect.text = "$correct"

        } else {
            rbSelected.startAnimation(wrongAnimation)
            rbSelected.setBackgroundResource(R.drawable.wrong_ans_bg)
            wrong++
            tvWrong.text = "$wrong"
            MUSIC_FLAG = 2
            playSound.seAudioforAnswers(MUSIC_FLAG)
            showSolution()
        }
    }

    private fun showSolution() {

        when (androidQuestionModel.answer) {
            1 -> {
                radio_button1.setBackgroundResource(R.drawable.correct_ans_bg)
            }
            2 -> {
                radio_button2.setBackgroundResource(R.drawable.correct_ans_bg)
            }
            3 -> {
                radio_button3.setBackgroundResource(R.drawable.correct_ans_bg)
            }
        }

        if (questionCounter < questionCount) {
            btnConfirm.text = "Next"
        } else {
            btnConfirm.text = "Finish"
        }
    }
}