package com.example.quizapp.Views

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Database.QuizRoomDatabase
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.R
import com.example.quizapp.Repository.QuizRepository
import com.example.quizapp.Utils.InsertAndroidQuestions
import com.example.quizapp.Utils.InsertCoroutinesQuestions
import com.example.quizapp.Utils.InsertKotlinQuestions
import com.example.quizapp.Utils.InsertMVVMQuestions
import com.example.quizapp.Utils.Utils.countDownInMilliSecond
import com.example.quizapp.Utils.Utils.countDownInterval
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory
import com.example.quizapp.databinding.ActivityQuizBinding
import kotlinx.android.synthetic.main.activity_quiz.*
import java.util.*
import java.util.concurrent.TimeUnit

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private var questionModelList = mutableListOf<QuestionModel>()
    private lateinit var quizViewModel: QuizViewModel
    private lateinit var questionModel: QuestionModel
    private lateinit var questionDAO: QuestionDAO
    private var questionCount: Int = 0
    private var questionCounter: Int = 0
    private var correct: Int = 0
    private var wrong: Int = 0
    private lateinit var correctAnimation: Animation
    private lateinit var wrongAnimation: Animation
    private var questionTotal: Int = 0
    private var isAnswered: Boolean = false
    private var countDownTimer: CountDownTimer? = null
    private var timeLeftMilliSeconds: Long = 0
    private var defaultColor: ColorStateList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultColor = tvTimer.textColors
        timeLeftMilliSeconds = countDownInMilliSecond
        startCountDownTimer()

        val topicName = intent.getStringExtra("TopicName").toString()

        questionDAO = QuizRoomDatabase.getQuestionObject(this).getQuestionDAO()
        val quizRepository = QuizRepository(questionDAO)
        val quizViewModelFactory = QuizViewModelFactory(quizRepository)
        quizViewModel =
            ViewModelProvider(this, quizViewModelFactory).get(QuizViewModel::class.java)


        wrongAnimation = AnimationUtils.loadAnimation(this, R.anim.incorrect_animation)
        wrongAnimation.repeatCount = 3

        correctAnimation = AnimationUtils.loadAnimation(this, R.anim.right_ans_animation)
        correctAnimation.repeatCount = 3

        val insertQuestions = InsertAndroidQuestions()
        val kotlinQuestions = InsertKotlinQuestions()
        val coroutinesQuestions = InsertCoroutinesQuestions()
        val mvvmQuestions = InsertMVVMQuestions()

        when (topicName) {
            "Android" -> {

                for (i in 0..insertQuestions.insertQuestionToDB().size) {
                    quizViewModel.addQuestionData(insertQuestions.insertQuestionToDB()[i])
                }
            }
            "Kotlin" -> {

                for (i in 0..kotlinQuestions.insertKotlinQuestionToDB().size) {
                    quizViewModel.addQuestionData(kotlinQuestions.insertKotlinQuestionToDB()[i])
                }
            }
            "Coroutines" -> {

                for (i in 0..coroutinesQuestions.insertCoroutinesQuestion().size) {
                    quizViewModel.addQuestionData(coroutinesQuestions.insertCoroutinesQuestion()[i])
                }
            }
            "MVVM" -> {

                for (i in 0..mvvmQuestions.insertMVVMQuestionToDB().size) {
                    quizViewModel.addQuestionData(mvvmQuestions.insertMVVMQuestionToDB()[i])
                }
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
                    checkAnswerIsCorrectOrNot()
                } else {
                    Toast.makeText(this, "Please select an answer.", Toast.LENGTH_SHORT).show();
                }
            } else {
                moveToNextQuestion()
            }
        }
    }

    private fun startCountDownTimer() {
        countDownTimer = object : CountDownTimer(timeLeftMilliSeconds, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                binding.apply {
                    timeLeftMilliSeconds = millisUntilFinished
                    val second = TimeUnit.MILLISECONDS.toSeconds(timeLeftMilliSeconds).toInt()

                    val timer = String.format(Locale.getDefault(), "Time: %02d", second)
                    tvTimer.text = timer
                    if (timeLeftMilliSeconds < 10000) {
                        tvTimer.setTextColor(Color.RED)
                    } else {
                        tvTimer.setTextColor(defaultColor)
                    }
                }
            }
            override fun onFinish() {
                timeOverAlertDialog()
            }
        }.start()
    }
    private fun timeOverAlertDialog() {
        val builder = Dialog(this)
        builder.setContentView(R.layout.time_over_dialog)

        val timeOverOk = builder.findViewById<Button>(R.id.timeOver_ok)
        if (builder.window != null) {
            builder.window!!.setBackgroundDrawable(ColorDrawable(0))
        }

        timeOverOk.setOnClickListener {
            builder.dismiss()
            finish()
        }

        builder.show()
        builder.setCancelable(false)
        builder.setCanceledOnTouchOutside(false)
    }

    private fun moveToNextQuestion() {
        btnConfirm.text = "Check Answer"

        val topicName: String = intent.getStringExtra("TopicName").toString()

        questionTotal++

        tvTotalQuestions.text = "$questionTotal / ${questionModelList.size - 1}"

        radio_group.clearCheck()
        radio_button1.setTextColor(Color.BLACK)
        radio_button2.setTextColor(Color.BLACK)
        radio_button3.setTextColor(Color.BLACK)

        radio_button1.setBackgroundColor(Color.TRANSPARENT)
        radio_button2.setBackgroundColor(Color.TRANSPARENT)
        radio_button3.setBackgroundColor(Color.TRANSPARENT)

        if (topicName == "Android" || topicName == "Kotlin" || topicName == "Coroutines" || topicName == "MVVM") {
            if (questionCounter < questionCount) {
                questionModel = questionModelList[questionCounter]
                tvQuestion.text = questionModel.question
                radio_button1.text = questionModel.option1
                radio_button2.text = questionModel.option2
                radio_button3.text = questionModel.option3
                questionCounter++
                isAnswered = false

            } else {
                quizEnded()
            }
        } else {
            layoutMain.visibility = View.GONE
        }
    }

    private fun quizEnded() {
        val intent = Intent(this, RecapActivity::class.java)
        intent.putExtra("correct", correct)
        intent.putExtra("wrong", wrong)
        intent.putExtra("question", questionModel.question)

        startActivity(intent)
    }

    private fun checkAnswerIsCorrectOrNot() {
        isAnswered = true
        val rbSelected: RadioButton = findViewById(radio_group.checkedRadioButtonId)

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        if (rbSelected.text == questionModel.answer) {
            rbSelected.setBackgroundResource(R.drawable.correct_ans_bg)
            rbSelected.startAnimation(correctAnimation)
            correct++
            //Log.d("correct", "working ${correct}")
            tvCorrect.text = "$correct"

            editor.putString("selected_option", rbSelected.text as String?)
            editor.apply()

        } else {
            rbSelected.startAnimation(wrongAnimation)
            rbSelected.setBackgroundResource(R.drawable.wrong_ans_bg)
            wrong++
            tvWrong.text = "$wrong"
            //Log.d("wrong", "working ${wrong}")

            //showSolution()

            editor.putString("selected_option", rbSelected.text as String?)
            editor.apply()

            for (i in 0 until radio_group.childCount) {
                val rb = radio_group.getChildAt(i) as RadioButton
                if (rb.text == questionModel.answer) {
                    rb.startAnimation(correctAnimation)
                    rb.setBackgroundResource(R.drawable.correct_ans_bg)

                    editor.putString("correct_option", rb.text as String?)
                    editor.apply()
                    break
                }
            }
        }
        btnConfirm.text = "Next Question"
    }

    private fun showSolution() {

        when (questionModel.answer) {
/*            1 -> {
                radio_button1.setBackgroundResource(R.drawable.correct_ans_bg)
            }
            2 -> {
                radio_button2.setBackgroundResource(R.drawable.correct_ans_bg)
            }
            3 -> {
                radio_button3.setBackgroundResource(R.drawable.correct_ans_bg)

            }*/
        }

        if (questionCounter < questionCount) {
            btnConfirm.text = "Next Question"
        } else {
            btnConfirm.text = "Finish Quiz"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer?.cancel()
    }
}