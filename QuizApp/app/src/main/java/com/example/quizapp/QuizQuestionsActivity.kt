package com.example.quizapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var tvCount : TextView? = null
    private var progressBar : ProgressBar? = null
    private var tvQuestion : TextView? = null
    private var ivFlag : ImageView? = null
    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var buttonSubmit : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        tvCount = findViewById(R.id.tv_count)
        progressBar = findViewById(R.id.tv_progressBar)
        tvQuestion = findViewById(R.id.tv_question)
        ivFlag = findViewById(R.id.iv_flag)
        tvOptionOne = findViewById(R.id.tv_optionOne)
        tvOptionTwo = findViewById(R.id.tv_optionTwo)
        tvOptionThree = findViewById(R.id.tv_optionThree)
        tvOptionFour = findViewById(R.id.tv_optionFour)
        buttonSubmit = findViewById(R.id.btn_submit)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {

        Log.i("QuestionList size is", "${mQuestionsList?.size}")

        for (i in mQuestionsList!!) {
            Log.e("Questions", "$i")
        }

        val question = mQuestionsList!![mCurrentPosition]
        progressBar?.progress = mCurrentPosition
        tvCount?.text = "${mCurrentPosition + 1}/${mQuestionsList!!.size}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        ivFlag?.setImageResource(question.image)

        if(mCurrentPosition == mQuestionsList!!.size){
            buttonSubmit?.text = "FINISH"
        } else {
            buttonSubmit?.text = "SUBMIT"
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}