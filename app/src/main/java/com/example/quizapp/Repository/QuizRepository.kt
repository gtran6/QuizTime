package com.example.quizapp.Repository

import androidx.lifecycle.LiveData
import com.example.quizapp.Database.QuestionDAO
import com.example.quizapp.Model.QuestionModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuizRepository(private val questionDAO: QuestionDAO) {

    fun getAllRoutines(): LiveData<List<QuestionModel>> {
        return questionDAO.getAllQuestion()
    }

    fun addQuestionTORoom(questionModel: QuestionModel){
        CoroutineScope(Dispatchers.IO).launch {
            questionDAO.addQuestion(questionModel)
        }
    }

    fun deleteAllQuestions(){
        CoroutineScope(Dispatchers.IO).launch {
            questionDAO.deleteAllQuestion()
        }
    }
}