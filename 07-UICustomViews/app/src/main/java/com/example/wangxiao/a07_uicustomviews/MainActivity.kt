package com.example.wangxiao.a07_uicustomviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar

        if (actionbar != null) {
            actionbar.hide()
        }

    }
}
