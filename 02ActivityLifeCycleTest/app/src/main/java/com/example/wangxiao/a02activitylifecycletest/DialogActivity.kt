package com.example.wangxiao.a02activitylifecycletest

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class DialogActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }
}
