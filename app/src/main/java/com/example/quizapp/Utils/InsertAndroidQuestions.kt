package com.example.quizapp.Utils

import com.example.quizapp.Model.QuestionModel

class InsertAndroidQuestions {
    private var list = mutableListOf<QuestionModel>()

    fun insertQuestionToDB(): MutableList<QuestionModel> {
        val model1 = QuestionModel(
            "Android Web Browser Is Based On?",
            "Safari",
            "Firefox",
            "Open-source Webkit",
            3
        )
        list.add(model1)

        val model2 = QuestionModel(
            "Which of the following virtual machine is used by the Android operating system?",
            "Dalvik virtual machine",
            "JVM",
            "Simple virtual machine",
            1
        )
        list.add(model2)

        val model3 = QuestionModel(
            " What is the use of content provider in Android?",

            "For storing the data in the database",
            "For sharing the data between applications",
            "For sending the data from an application to another application",
            3
        )
        list.add(model3)

        val model4 = QuestionModel(
            " APK stands for??",

            "Android Phone Kit",
            "Android Page Kit",
            "Android Package Kit",
            3
        )
        list.add(model4)

        val model5 = QuestionModel(
            "What does API stand for?",

            "Android Programming Interface",
            "Application Programming Interface",
            "Android Page Interface",
            1
        )

        list.add(model5)

        val model6 = QuestionModel(
            " What is an activity in android?",

            "android class",
            "android package",
            "A single screen in an application with supporting java code",
            3
        )
        list.add(model6)

        val model7 = QuestionModel(
            "What Does AAPT Stands For?",
            "Android Asset Processing Tool.",
            "Android Asset Providing Tool.",
            "Android Asset Packaging Tool.",
            3
        )
        list.add(model7)

        val model8 = QuestionModel(
            ". What Are The Functionalities In AsyncTask In Android?",
            "OnPostExecution()",
            "OnPreExecution()",
            "DoInBackground()",
            1
        )
        list.add(model8)

        val model9 = QuestionModel(
            "View Pager Is Used For?",
            "Swiping Activities",
            "Swiping Fragments",
            "Paging Down List Items",
            2
        )
        list.add(model9)

        val model10 = QuestionModel(
            "Android Is Based On Which Kernel?",
            "Windows",
            "Linux",
            "Redhat",
            2
        )
        list.add(model10)

        return list
    }

}