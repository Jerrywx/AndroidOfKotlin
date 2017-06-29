package com.example.wangxiao.a01geoquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /// 问题
    var textView: TextView? = null

    val questions = arrayListOf<Question>(Question(R.string.question_1, false),
                                        Question(R.string.question_content, true),
                                        Question(R.string.question_3, false),
                                        Question(R.string.question_4, true),
                                        Question(R.string.question_5, false))

    var mCurrentIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// 设置问题内容
        textView = findViewById(R.id.question_text_view) as TextView
        updateQuestion()

        /// TRUE 按钮
        val trueButton = findViewById(R.id.true_button) as Button
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        /// FALSE 按钮
        val falseButton = findViewById(R.id.false_button) as Button
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        //// NEXT 按钮
        val nextButton = findViewById(R.id.next_button) as Button
        nextButton.setOnClickListener {
            mCurrentIndex = (mCurrentIndex + 1) % questions.count()
            updateQuestion()
        }

        /// Pro 按钮
        val proButton = findViewById(R.id.pro_button) as Button
        proButton.setOnClickListener {
            mCurrentIndex = mCurrentIndex - 1
            if (mCurrentIndex < 0) {
                mCurrentIndex = questions.count() - 1
            }
            updateQuestion()
        }
    }

    /// 更新问题按钮
    fun updateQuestion() {
        val question = questions[mCurrentIndex].mTextResId
        textView?.setText(question)
    }

    /// 检查问题
    fun checkAnswer(userPressedTrue: Boolean) {
        val answer = questions[mCurrentIndex].mAnswerTrue

        if (userPressedTrue == answer) {
            Toast.makeText(this, "对", Toast.LENGTH_SHORT).show()
            mCurrentIndex = (mCurrentIndex + 1) % questions.count()
            updateQuestion()
        } else {
            Toast.makeText(this, "错", Toast.LENGTH_SHORT).show()
        }

    }

}
