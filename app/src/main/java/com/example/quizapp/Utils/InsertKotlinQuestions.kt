package com.example.quizapp.Utils

import com.example.quizapp.Model.QuestionModel

class InsertKotlinQuestions {
    private var questionModelList = mutableListOf<QuestionModel>()

    fun insertKotlinQuestionToDB(): MutableList<QuestionModel> {
        val questionModel = QuestionModel(
            "Kotlin is developed by?",
            "Google",
            "Adobe",
            "JetBrains",
            3
        )
        questionModelList.add(questionModel)

        val questionModel1 = QuestionModel(
            "What is the default behavior of Kotlin classes?",
            "All classes are public",
            "All classes are sealed",
            "All classes are final",
            4
        )
        questionModelList.add(questionModel1)


        val questionModel2 = QuestionModel(
            "What is an immutable variable?",
            "A variable that can't change, read-only",
            "A variable that can be changed",
            "A variable used for string interpolation",
            1
        )
        questionModelList.add(questionModel2)


        val questionModel3 = QuestionModel(
            "Identify the correct way to create an arraylist in Kotlin?",
            "val list = arrayListOf(1, 2, 3)",
            "val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")",
            "val set = hashSetOf(1, 2, 3)",
            1
        )
        questionModelList.add(questionModel3)


        val questionModel4 = QuestionModel(
            "Which of following targets currently not supported by Kotlin?",
            ".NET CLR",
            "LLVM",
            "Javascript",
            1
        )

        questionModelList.add(questionModel4)

        val questionModel5 = QuestionModel(
            "How to make a multi lined comment in Kotlin?",
            "/ multi line comment /",
            "//",
            "/* */",
            1
        )
        questionModelList.add(questionModel5)

        val questionModel6 = QuestionModel(
            "Which file extension is used to save Kotlin files.",
            ".java",
            ".kot",
            ".kt or .kts",
            3
        )
        questionModelList.add(questionModel6)

        val questionModel7 = QuestionModel(
            "How many types of constructors available in Kotlin?",
            "1",
            "2",
            "3",
            2
        )
        questionModelList.add(questionModel7)

        val questionModel8 = QuestionModel(
            "What is the use of data class in Kotlin?",
            "extract the basic data types",
            "delete the basic data types",
            "holds the basic data types",
            3
        )
        questionModelList.add(questionModel8)

        val questionModel9 = QuestionModel(
            "What is the syntax for declaring a variable as volatile in Kotlin?",
            "var x: Long? = null",
            "Volatile var x: Long?",
            "Volatile var x: Long? = null",
            3
        )
        questionModelList.add(questionModel9)

        val questionModel10 = QuestionModel(
            "Which of th following is used to compare two strings in Kotlin?",
            "Using == operator",
            "Using compareTo()",
            "Both A and B",
            3
        )
        questionModelList.add(questionModel10)

        val questionModel11 = QuestionModel(
            "Elvis Operator is used for handling null expectations in Kotlin.",
            "True",
            "False",
            "Can be true or false",
            1
        )
        questionModelList.add(questionModel11)

        val questionModel12 = QuestionModel(
            "Does Kotlin support primitive Datatypes?",
            "Yes",
            "No",
            "Can be yes or no",
            2
        )
        questionModelList.add(questionModel12)

        val questionModel13 = QuestionModel(
            "Which of following option is used to handle null exceptions in Kotlin?",
            "Range",
            "Elvis Operator",
            "Sealed Class",
            2
        )
        questionModelList.add(questionModel13)

        val questionModel14 = QuestionModel(
            "Does Kotlin works only for Java?",
            "Yes",
            "No",
            "Can be yes or no",
            2
        )
        questionModelList.add(questionModel14)

        val questionModel15 = QuestionModel(
            "Which function changes the value of the element at the current iterator location?",
            "change()",
            "modify()",
            "set()",
            3
        )
        questionModelList.add(questionModel15)

        val questionModel16 = QuestionModel(
            "Can we execute Kotlin Code Without Jvm?",
            "Yes",
            "No",
            "Can be yes or no",
            1
        )
        questionModelList.add(questionModel16)

        val questionModel17 = QuestionModel(
            "What is the entry point for a Kotlin application?",
            "fun static main(){}",
            "fun main(){}",
            "fun Main(){}",
            2
        )
        questionModelList.add(questionModel17)

        return questionModelList
    }

}