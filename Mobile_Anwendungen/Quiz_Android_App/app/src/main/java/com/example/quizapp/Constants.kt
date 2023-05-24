package com.example.quizapp

object Constants {

    // Variables for the result screen
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {

        // 1
        val questionsList = ArrayList<Question> ()
        val que1 = Question(1,
            "What is the capital of France?",
            R.drawable.ic_question_mark,
            "Paris", "Berlin", "Madrid", "London",
            1
        )
        questionsList.add(que1)

        // 2
        val que2 =Question(2,
            "What is the largest planet in our solar system?",
            R.drawable.ic_question_mark,
            "Mars", "Jupiter", "Venus", "Saturn",
            2
        )
        questionsList.add(que2)

        // 3
        val que3 =Question(3,
            "What is the smallest country in the world?",
            R.drawable.ic_question_mark,
            "Monaco", "Liechtenstein", "Vatican City", "San Marino",
            3
        )
        questionsList.add(que3)

        // 4
        val que4 = Question(4,
            "What is the largest country in the world?",
            R.drawable.ic_question_mark,
            "USA", "China", "Russia", "India",
            3
        )
        questionsList.add(que4)

        // 5
        val que5 = Question(5,
            "What is the currency of Japan?",
            R.drawable.ic_question_mark,
            "Yen", "Dollar", "Euro", "Pound",
            4
        )
        questionsList.add(que5)

        // 6
        val que6 = Question(6,
            "What country has the highest life expectancy?",
            R.drawable.ic_question_mark,
            "Germany", "USA", "Hong Kong", "India",
            3
        )
        questionsList.add(que6)

        // 7
        val que7 = Question(7,
            "Where would you be if you were standing on the Spanish Steps?",
            R.drawable.ic_question_mark,
            "Madrid", "Rome", "Berlin", "Boenos Aires",
            2
        )
        questionsList.add(que7)

        // 8
        val que8 = Question(8,
            "What is the most common surname in the United States?",
            R.drawable.ic_question_mark,
            "Smith", "Wesson", "Griffin", "Simson",
            1
        )
        questionsList.add(que8)

        // 9
        val que9 = Question(9,
            "Who was the Ancient Greek God of the Sun?",
            R.drawable.ic_question_mark,
            "Mars", "Venus", "Jupiter", "Apollo",
            4
        )
        questionsList.add(que9)

        // 10
        val que10 = Question(10,
            "What year was the United Nations established?",
            R.drawable.ic_question_mark,
            "1960", "1989", "1945", "1980",
            3
        )
        questionsList.add(que10)

        // 11
        val que11 = Question(11,
            "Who has won the most total Academy Awards?",
            R.drawable.ic_question_mark,
            "Walt Disney", "Arnold Schwarzenegger", "Pierce Brendan Brosnan", "Clint Eastwood",
            1
        )
        questionsList.add(que11)

        // 12
        val que12 = Question(12,
            "What artist has the most streams on Spotify?",
            R.drawable.ic_question_mark,
            "Pink", "Drake", "Daft Punk", "Snoop Dogg",
            2
        )
        questionsList.add(que12)

        // 13
        val que13 = Question(13,
            "How many minutes are in a full week",
            R.drawable.ic_question_mark,
            "12,040", "12,000", "6,090", "10,080",
            4
        )
        questionsList.add(que13)

        // 14
        val que14 = Question(14,
            "What car manufacturer had the highest revenue in 2020?",
            R.drawable.ic_question_mark,
            "Fiat", "Opel", "Volkswagen", "General Motors",
            3
        )
        questionsList.add(que14)

        // 15
        val que15 = Question(15,
            "How many elements are in the periodic table?",
            R.drawable.ic_question_mark,
            "108", "118", "116", "124",
            2
        )
        questionsList.add(que15)

        // 16
        val que16 = Question(16,
            "What company was originally called \"Cadabra\"?",
            R.drawable.ic_question_mark,
            "Cadabra Inc", "Alibaba", "Amazon", "Cadabra Studio",
            3
        )
        questionsList.add(que16)

        // 17
        val que17 = Question(17,
            "Queen guitarist Brian May is also an expert in what scientific field? ",
            R.drawable.ic_question_mark,
            "Astrophysics", "Mathematics", "Physics", "Computer and informations",
            1
        )
        questionsList.add(que17)

        // 18
        val que18 = Question(18,
            "Aureolin is a shade of what color? ",
            R.drawable.ic_question_mark,
            "Brown", "Red", "Blue", "Yellow",
            4
        )
        questionsList.add(que18)

        // 19
        val que19 = Question(19,
            "How many ghosts chase Pac-Man at the start of each game?",
            R.drawable.ic_question_mark,
            "8", "4", "2", "6",
            2
        )
        questionsList.add(que19)

        // 20
        val que20 = Question(20,
            "What character has both Robert Downey Jr. and Benedict Cumberbatch played?",
            R.drawable.ic_question_mark,
            "Iron Man", "Doctor Strange", "Sherlock Holmes", "Charlie Caplin",
            3
        )
        questionsList.add(que20)

        // add more questions here

        return questionsList
    }
}