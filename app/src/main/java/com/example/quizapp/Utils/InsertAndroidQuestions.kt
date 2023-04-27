package com.example.quizapp.Utils

import com.example.quizapp.Model.AndroidQuestionModel
import com.example.quizapp.ViewModel.QuizViewModel
import com.example.quizapp.ViewModel.QuizViewModelFactory

class InsertAndroidQuestions {
    private var questionModelList = mutableListOf<AndroidQuestionModel>()

    fun insertQuestionToDB(): MutableList<AndroidQuestionModel> {
        val questionModel = AndroidQuestionModel(
            "Android Web Browser Is Based On?",
            "Safari",
            "Firefox",
            "Open-source Webkit",
            3
        )
        questionModelList.add(questionModel)

        val questionModel1 = AndroidQuestionModel(
            "Which of the following virtual machine is used by the Android operating system?",
            "Dalvik virtual machine",
            "JVM",
            "Simple virtual machine",
            1
        )
        questionModelList.add(questionModel1)


        val questionModel2 = AndroidQuestionModel(
            " What is the use of content provider in Android?",

            "For storing the data in the database",
            "For sharing the data between applications",
            "For sending the data from an application to another application",
            3
        )
        questionModelList.add(questionModel2)


        val questionModel3 = AndroidQuestionModel(
            " APK stands for??",

            "Android Phone Kit",
            "Android Page Kit",
            "Android Package Kit",
            3
        )
        questionModelList.add(questionModel3)


        val questionModel4 = AndroidQuestionModel(
            "What does API stand for?",

            "Android Programming Interface",
            "Application Programming Interface",
            "Android Page Interface",
            1
        )

        questionModelList.add(questionModel4)

        val questionModel5 = AndroidQuestionModel(
            " What is an activity in android?",

            "android class",
            "android package",
            "A single screen in an application with supporting java code",
            3
        )
        questionModelList.add(questionModel5)

        val questionModel6 = AndroidQuestionModel(
            "What Does AAPT Stands For?",
            "Android Asset Processing Tool.",
            "Android Asset Providing Tool.",
            "Android Asset Packaging Tool.",
            3
        )
        questionModelList.add(questionModel6)

        val questionModel7 = AndroidQuestionModel(
            ". What Are The Functionalities In AsyncTask In Android?",
            "OnPostExecution()",
            "OnPreExecution()",
            "DoInBackground()",
            1
        )
        questionModelList.add(questionModel7)

        val questionModel8 = AndroidQuestionModel(
            "View Pager Is Used For?",
            "Swiping Activities",
            "Swiping Fragments",
            "Paging Down List Items",
            2
        )
        questionModelList.add(questionModel8)

        val questionModel9 = AndroidQuestionModel(
            "Android Is Based On Which Kernal?",
            "Windows",
            "Linux",
            "Redhat",
            2
        )
        questionModelList.add(questionModel9)

        val questionModel10 = AndroidQuestionModel(
            "What is Manifest.xml in android?",
            "Information about layout in an application",
            "The information about activities in an application",
            "All the information about an application",
            3
        )
        questionModelList.add(questionModel10)

        val questionModel11 = AndroidQuestionModel(
            "Which code used by Android is not a open source?",
            "WiFi Driver",
            "Device Driver",
            "Video Driver",
            1
        )
        questionModelList.add(questionModel11)

        val questionModel12 = AndroidQuestionModel(
            "Android is based on Linux for the following reason.",
            "Portability",
            "Security",
            "All are Correct",
            3
        )
        questionModelList.add(questionModel12)

        val questionModel13 = AndroidQuestionModel(
            "Which among these are NOT a part of Android’s native libraries?",
            "OpenGL",
            "Webkit",
            "Dalvik",
            3
        )
        questionModelList.add(questionModel13)

        val questionModel14 = AndroidQuestionModel(
            "What does the src folder contain?",
            "XML resource files",
            "Java source code files",
            "Image and icon files",
            2
        )
        questionModelList.add(questionModel14)

        val questionModel15 = AndroidQuestionModel(
            "Which one is not a nickname of a version of Andriod?",
            "cupcake",
            "Muffin",
            "Gingerbread",
            2
        )
        questionModelList.add(questionModel15)
        return questionModelList
    }

}