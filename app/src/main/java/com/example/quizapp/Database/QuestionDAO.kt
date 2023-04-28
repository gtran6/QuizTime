package com.example.quizapp.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quizapp.Model.QuestionModel


@Dao
interface QuestionDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addQuestion(questionModel: QuestionModel)

    @Query("select * from question_table")
    fun getAllQuestion(): LiveData<List<QuestionModel>>

    @Query("delete from question_table")
    fun deleteAllQuestion()
}