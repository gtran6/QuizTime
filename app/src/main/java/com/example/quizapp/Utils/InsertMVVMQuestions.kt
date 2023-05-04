package com.example.quizapp.Utils

import com.example.quizapp.Model.QuestionModel

class InsertMVVMQuestions {

    private var questionModelList = mutableListOf<QuestionModel>()

    fun insertMVVMQuestionToDB(): MutableList<QuestionModel> {
        val questionModel = QuestionModel(
            "What does MVVM stand for in Android development?",
            "Model View ViewModel",
            "Main View Model Manager",
            "Model View Controller",
            "Model View ViewModel"
        )
        questionModelList.add(questionModel)

        val questionModel1 = QuestionModel(
            "How does the ViewModel communicate with the View in MVVM?",
            "Through a callback interface",
            "Through the Observer pattern",
            "Through an Intent",
            "Through the Observer pattern"
        )
        questionModelList.add(questionModel1)


        val questionModel2 = QuestionModel(
            "What is the purpose of LiveData in MVVM?",
            "To observe changes in the data and update the UI accordingly",
            "To hold the data in the ViewModel",
            "To handle user interactions in the ViewModel",
            "To observe changes in the data and update the UI accordingly"
        )
        questionModelList.add(questionModel2)


        val questionModel3 = QuestionModel(
            "Which component in MVVM is responsible for handling business logic?",
            "ViewModel",
            "View",
            "Model",
            "ViewModel"
        )
        questionModelList.add(questionModel3)


        val questionModel4 = QuestionModel(
            "What is the main advantage of using MVVM in Android development?",
            "Better separation of concerns",
            "Easier implementation of complex UI",
            "Better performance",
            "Better separation of concerns"
        )

        questionModelList.add(questionModel4)

        val questionModel5 = QuestionModel(
            "What is the recommended way to implement data binding in MVVM?",
            "Using the Android Data Binding library",
            "Manually setting the values in the UI components",
            "Using a third-party library",
            "Using the Android Data Binding library"
        )
        questionModelList.add(questionModel5)

        val questionModel6 = QuestionModel(
            "What is the recommended way to handle configuration changes (such as screen rotations) in MVVM architecture?",
            "Store the ViewModel state in a Bundle and restore it after the configuration change",
            "Use the ViewModel's onCleared() method to reset the state after the configuration change",
            "Use the SavedStateHandle to store the ViewModel state across configuration changes",
            "Use the SavedStateHandle to store the ViewModel state across configuration changes"
        )
        questionModelList.add(questionModel6)

        val questionModel7 = QuestionModel(
            "Which lifecycle method of the ViewModel component is called when the associated View is destroyed?",
            "onStart()",
            "onCleared()",
            "onCreate()",
            "onCleared()"
        )
        questionModelList.add(questionModel7)

        val questionModel8 = QuestionModel(
            "How can you handle dependency injection in MVVM architecture?",
            "Use the Dagger library to inject dependencies into the ViewModel",
            "Use the ViewModel's constructor to pass dependencies from the View",
            "Use the ViewModel's constructor to pass dependencies from the View",
            "Use the ViewModel's constructor to pass dependencies from the View"
        )
        questionModelList.add(questionModel8)

        val questionModel9 = QuestionModel(
            "What is the recommended way to implement navigation between different screens or fragments in MVVM architecture?",
            "Use Intents to start different activities or fragments",
            "Use the ViewModel to directly manipulate the FragmentManager",
            "Use the Navigation Component library to handle navigation",
            "Use the Navigation Component library to handle navigation"
        )
        questionModelList.add(questionModel9)

        return questionModelList
    }
}