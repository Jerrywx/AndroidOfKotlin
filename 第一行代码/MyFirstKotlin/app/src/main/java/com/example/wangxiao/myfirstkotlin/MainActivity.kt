package com.example.wangxiao.myfirstkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addAction()
    }

    /// 界面设置
    fun addAction() {

        var kotlinButton = findViewById(R.id.kotlin)
        kotlinButton.setOnClickListener {
            var intent = Intent(this, ViewActivity::class.java)
            startActivity(intent)
        }

    }

}
