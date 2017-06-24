package com.example.wangxiao.myfirstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        println("调用函数------------ ${sum(3, 7)}")
    }

    /// 1. 定义包

    /// 2. 定义函数

    fun sum(a: Int, b: Int): Int {
        return a + b
    }


    /// 3.


}
