package com.example.quizapp.Utils

import com.example.quizapp.Model.CoroutinesQuestionModel

class InsertCoroutinesQuestions {
    private val list = mutableListOf<CoroutinesQuestionModel>()

    fun insertQuestion(): MutableList<CoroutinesQuestionModel> {
        val model1 = CoroutinesQuestionModel(
            "Q.1. What is a Coroutine in Kotlin?",
            "A function that returns multiple values",
            "A function that runs in the background",
            "A function that can be paused and resumed at a later time",
            3
        )
        list.add(model1)

        val model2 = CoroutinesQuestionModel(
            "Q.2. Which keyword is used to start a Coroutine in Kotlin?",
            "await",
            "launch",
            "execute",
            2
        )
        list.add(model2)

        val model3 = CoroutinesQuestionModel(
            "Q.3. What is the purpose of the withContext() function in Coroutines?",
            "To switch to a different thread",
            "To pause the Coroutine and wait for a result",
            "To cancel the Coroutine",
            1
        )
        list.add(model3)

        val model4 = CoroutinesQuestionModel(
            "Q.4. Which of the following is a benefit of using Coroutines in Android?",
            "Improved battery life",
            "Faster app startup time",
            "More efficient use of system resources",
            3
        )
        list.add(model4)

        val model5 = CoroutinesQuestionModel(
            "Q.5. Which of the following is a disadvantage of using Coroutines in Android?",
            "Increased memory usage",
            "Increased code complexity",
            "Slower performance",
            2
        )
        list.add(model5)

        val model6 = CoroutinesQuestionModel(
            "Q.6. Which method is used to run a Coroutine in the Main thread in Android?",
            "runBlocking()",
            "withContext(Dispatchers.Main)",
            "GlobalScope.launch()",
            2
        )
        list.add(model6)

        val model7 = CoroutinesQuestionModel(
            "Q.7. What is the purpose of a Deferred object in Coroutines?",
            "To hold the result of a Coroutine computation",
            "To pause a Coroutine and wait for a result",
            "To cancel a Coroutine",
            1
        )
        list.add(model7)

        val model8 = CoroutinesQuestionModel(
            "Q.8. Which of the following is true about Coroutines and exceptions?",
            "Coroutines can't handle exceptions",
            "Coroutines can handle exceptions using try/catch blocks",
            "Coroutines can handle exceptions automatically",
            2
        )
        list.add(model8)

        val model9 = CoroutinesQuestionModel(
            "Q.9. Which of the following is true about Coroutines and concurrency?",
            "Coroutines always run concurrently",
            "Coroutines never run concurrently",
            "Coroutines can run concurrently if they're launched in different threads",
            3
        )
        list.add(model9)

        val model10 = CoroutinesQuestionModel(
            "Q.10. Which Coroutine builder is used to launch a new Coroutine that runs indefinitely?",
            "launch",
            "runBlocking",
            "repeat",
            1
        )
        list.add(model10)

        return list
    }
}