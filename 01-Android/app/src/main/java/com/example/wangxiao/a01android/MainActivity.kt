package com.example.wangxiao.a01android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.util.LogWriter
import android.util.EventLogTags
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// log
        Log.d("Hello, ", "world !")

        setButton()

    }

    /// 设置按钮点击事件
    fun setButton() {
        val button: Button = findViewById(R.id.button_1) as Button

        button.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        }
    }

    /// 设置菜单点击事件



}
