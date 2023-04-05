package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var answer1RadioButton: RadioButton
    private lateinit var answer2RadioButton: RadioButton
    private lateinit var answer3RadioButton: RadioButton
    private lateinit var answer4RadioButton: RadioButton
    private lateinit var submitAnswerButton: Button
    private var currentQuestionIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionTextView = findViewById(R.id.questionTextView)
        answer1RadioButton = findViewById(R.id.answer1RadioButton)
        answer2RadioButton = findViewById(R.id.answer2RadioButton)
        answer3RadioButton = findViewById(R.id.answer3RadioButton)
        answer4RadioButton = findViewById(R.id.answer4RadioButton)
        submitAnswerButton = findViewById(R.id.submitAnswerButton)

        showQuestion()
        submitAnswerButton.setOnClickListener {
            checkAnswer()
        }
    }

        private fun showQuestion() {
            val question = QuestionBank.questions[currentQuestionIndex]
            questionTextView.text = question.text
            answer1RadioButton.text = question.answers[0]
            answer2RadioButton.text = question.answers[1]
            answer3RadioButton.text = question.answers[2]
            answer4RadioButton.text = question.answers[3]
        }

        private fun checkAnswer() {
            val question = QuestionBank.questions[currentQuestionIndex]
            val selectedAnswer = when (answersRadioGroup.checkedRadioButtonId) {
                R.id.answer1RadioButton -> 0
                R.id.answer2RadioButton -> 1
                R.id.answer3RadioButton -> 2
                R.id.answer4RadioButton -> 3
                else -> -1
            }

            if (selectedAnswer == question.correctAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
            }

            currentQuestionIndex++
            if (currentQuestionIndex < QuestionBank.questions.size) {
                showQuestion()
            } else {
                Toast.makeText(this, "Quiz complete!", Toast.LENGTH_SHORT).show()
            }
        }

        data class Question(
        val text: String,
        val answers: List<String>,
        val correctAnswer: Int
    )

    object QuestionBank {
        val questions = listOf(
            Question(
                "What is the capital of France?",
                listOf("Paris", "Berlin", "Madrid", "London"),
                1
            ),
            Question(
                "What is the largest planet in our solar system?",
                listOf("Mars", "Jupiter", "Venus", "Saturn"),
                2
            ),
            Question(
                "What is the smallest country in the world?",
                listOf("Monaco", "Liechtenstein", "Vatican City", "San Marino"),
                3
            ),
            Question(
                "What is the largest country in the world?",
                listOf("USA", "China", "Russia", "India"),
                3
            ),
            Question(
                "What is the currency of Japan?",
                listOf("Yen", "Dollar", "Euro", "Pound"),
                4
            ),
            Question(
                "What country has the highest life expectancy?",
                listOf("Germany", "USA", "Hong Kong", "India"),
                3
            ),
            Question(
                "Where would you be if you were standing on the Spanish Steps?",
                listOf("Madrid", "Rome", "Berlin", "Boenos Aires"),
                2
            ),
            Question(
                "What is the most common surname in the United States?",
                listOf("Smith", "Wesson", "Griffin", "Simson"),
                1
            ),
            Question(
                "Who was the Ancient Greek God of the Sun?",
                listOf("Mars", "Venus", "Jupiter", "Apollo"),
                4
            ),
            Question(
                "What year was the United Nations established?",
                listOf("1960", "1989", "1945", "1980"),
                3
            ),
            Question(
                "Who has won the most total Academy Awards?",
                listOf("Walt Disney", "Arnold Schwarzenegger", "Pierce Brendan Brosnan", "Clint Eastwood"),
                1
            ),
            Question(
                "What artist has the most streams on Spotify?",
                listOf("Pink", "Drake", "Daft Punk", "Snoop Dogg"),
                2
            ),
            Question(
                "How many minutes are in a full week",
                listOf("12,040", "12,000", "6,090", "10,080"),
                4
            ),
            Question(
                "What car manufacturer had the highest revenue in 2020?",
                listOf("Fiat", "Opel", "Volkswagen", "General Motors"),
                3
            ),
            Question(
                "How many elements are in the periodic table?",
                listOf("108", "118", "116", "124"),
                2
            ),
            Question(
                "What company was originally called \"Cadabra\"?",
                listOf("Cadabra Inc", "Alibaba", "Amazon", "Cadabra Studio"),
                3
            ),
            Question(
                "Queen guitarist Brian May is also an expert in what scientific field? ",
                listOf("Astrophysics", "Mathematics", "Physics", "Computer and informations"),
                1
            ),
            Question(
                "Aureolin is a shade of what color? ",
                listOf("Brown", "Red", "Blue", "Yellow"),
                4
            ),
            Question(
                "How many ghosts chase Pac-Man at the start of each game?",
                listOf("8", "4", "2", "6"),
                2
            ),
            Question(
                "What character has both Robert Downey Jr. and Benedict Cumberbatch played?",
                listOf("Iron Man", "Doctor Strange", "Sherlock Holmes", "Charlie Caplin"),
                3
            ),
            // add more questions here
            )
    }
}