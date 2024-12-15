package com.pixeleye.myapplication

object Constant{
    fun getQuestion():ArrayList<QuestionClass>{
        val questionList = ArrayList<QuestionClass>()

        val qu1 = QuestionClass(
            0,
            "What country does this flag belong to?",
            R.drawable.angola,
            "Angola",
            "Afghanistan",
            "Albania",
            "Andorra",
            1
        )
        questionList.add(qu1)

        val qu2 = QuestionClass(
            1,
            "What country does this flag belong to?",
            R.drawable.turkey,
            "Angola",
            "Afghanistan",
            "Turkey",
            "Andorra",
            3
        )
        questionList.add(qu2)

        val qu3 = QuestionClass(
            2,
            "What country does this flag belong to?",
            R.drawable.australia,
            "Angola",
            "Afghanistan",
            "Australia",
            "Andorra",
            3
        )
        questionList.add(qu3)

        val qu4 = QuestionClass(
            3,
            "What country does this flag belong to?",
            R.drawable.azerbaijan,
            "Angola",
            "Azerbaijan",
            "Australia",
            "Andorra",
            2
        )
        questionList.add(qu4)

        val qu5 = QuestionClass(
            4,
            "What country does this flag belong to?",
            R.drawable.costa_rica,
            "Argentina",
            "Afghanistan",
            "Australia",
            "Costa Rica",
            4
        )
        questionList.add(qu5)

        val qu6 = QuestionClass(
            5,
            "What country does this flag belong to?",
            R.drawable.united_states,
            "Belgium",
            "USA",
            "Australia",
            "Andorra",
            2
        )
        questionList.add(qu6)

        return questionList
    }
}