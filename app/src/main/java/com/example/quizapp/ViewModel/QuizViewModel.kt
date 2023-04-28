package com.example.quizapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.Model.QuestionModel
import com.example.quizapp.Repository.QuizRepository

class QuizViewModel(val repo: QuizRepository) : ViewModel() {

    fun addQuestionData(questionModel: QuestionModel){
        repo.addQuestionTORoom(questionModel)
    }

    fun getAndroidQuestions(): LiveData<List<QuestionModel>> {
        return repo.getAllRoutines()
    }

    fun deleteAllQuestions(){
        repo.deleteAllQuestions()
    }

}