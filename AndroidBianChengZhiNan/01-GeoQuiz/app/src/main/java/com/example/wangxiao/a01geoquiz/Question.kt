package com.example.wangxiao.a01geoquiz

/**
 * Created by wangxiao on 2017/6/29.
 */

public class Question constructor(textResId: Int, answerTrue: Boolean) {

    var mTextResId: Int = 0
    var mAnswerTrue: Boolean = false

    init {
        this.mAnswerTrue = answerTrue
        this.mTextResId = textResId
    }

}