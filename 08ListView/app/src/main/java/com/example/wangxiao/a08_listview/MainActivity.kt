package com.example.wangxiao.a08_listview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list_button: Button = findViewById(R.id.list_button) as Button
        list_button.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        val list_button2: Button = findViewById(R.id.list_button2) as Button
        list_button2.setOnClickListener {
            val intent = Intent(this, ListViewActivity2::class.java)
            startActivity(intent)
        }
    }
}
