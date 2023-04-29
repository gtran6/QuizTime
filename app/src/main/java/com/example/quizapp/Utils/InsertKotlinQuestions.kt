package com.example.quizapp.Utils

import com.example.quizapp.Model.QuestionModel

class InsertKotlinQuestions {
    private var questionModelList = mutableListOf<QuestionModel>()

    fun insertKotlinQuestionToDB(): MutableList<QuestionModel> {
        val model1 = QuestionModel(
            "Kotlin is developed by?",
            "Google",
            "Adobe",
            "JetBrains",
            3
        )
        questionModelList.add(model1)

        val model2 = QuestionModel(
            "What is the default behavior of Kotlin classes?",
            "All classes are public",
            "All classes are sealed",
            "All classes are final",
            4
        )
        questionModelList.add(model2)

        val model3 = QuestionModel(
            "What is an immutable variable?",
            "A variable that can't change, read-only",
            "A variable that can be changed",
            "A variable used for string interpolation",
            1
        )
        questionModelList.add(model3)

        val model4 = QuestionModel(
            "Identify the correct way to create an arraylist in Kotlin?",
            "val list = arrayListOf(1, 2, 3)",
            "val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")",
            "val set = hashSetOf(1, 2, 3)",
            1
        )
        questionModelList.add(model4)

        val model5 = QuestionModel(
            "Which of following targets currently not supported by Kotlin?",
            ".NET CLR",
            "LLVM",
            "Javascript",
            1
        )

        questionModelList.add(model5)

        val model6 = QuestionModel(
            "How to make a multi lined comment in Kotlin?",
            "/ multi line comment /",
            "//",
            "/* */",
            1
        )
        questionModelList.add(model6)

        val model7 = QuestionModel(
            "Which file extension is used to save Kotlin files.",
            ".java",
            ".kot",
            ".kt or .kts",
            3
        )
        questionModelList.add(model7)

        val model8 = QuestionModel(
            "How many types of constructors available in Kotlin?",
            "1",
            "2",
            "3",
            2
        )
        questionModelList.add(model8)

        val model9 = QuestionModel(
            "What is the use of data class in Kotlin?",
            "extract the basic data types",
            "delete the basic data types",
            "holds the basic data types",
            3
        )
        questionModelList.add(model9)

        val model10 = QuestionModel(
            "What is the syntax for declaring a variable as volatile in Kotlin?",
            "var x: Long? = null",
            "Volatile var x: Long?",
            "Volatile var x: Long? = null",
            3
        )
        questionModelList.add(model10)

        return questionModelList
    }

}