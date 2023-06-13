package com.example.quizapp

object Constants {
    fun getQuestions(): ArrayList<Question> {

        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "To which country does this flag belong?", R.drawable.ic_india,
            "Canada", "India", "Sri lanka", "China",
            2
        )
        questionList.add(que1)

        val que2 = Question(
            2, "To which country does this flag belong?", R.drawable.ic_china,
            "Taiwan", "Malaysia", "Myanmar", "China",
            4
        )
        questionList.add(que2)

        val que3 = Question(
            3, "To which country does this flag belong?", R.drawable.ic_canada,
            "United States", "Argentina", "Canada", "South Africa",
            3
        )
        questionList.add(que3)

        val que4 = Question(
            4, "To which country does this flag belong?", R.drawable.ic_japan,
            "Japan", "Malaysia", "Taiwan", "Russia",
            1
        )
        questionList.add(que4)

        val que5 = Question(
            5, "To which country does this flag belong?", R.drawable.ic_usa,
            "Iraq", "United state", "Uganda", "Iran",
            2
        )
        questionList.add(que5)

        val que6 = Question(
            6, "To which country does this flag belong?", R.drawable.ic_usa,
            "Russia", "Thailand", "Uzbekistan", "Ukraine",
            2
        )
        questionList.add(que6)

        return questionList

    }
}