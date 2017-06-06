package com.example.wangxiao.a13sharedpreferences

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var saveButton = findViewById(R.id.save_data) as Button
        saveButton.setOnClickListener {

            var editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()

            editor.putString("name", "Tom")
            editor.putInt("age", 28)
            editor.putBoolean("married", false)
            editor.apply()

            Toast.makeText(this, "OK!", Toast.LENGTH_SHORT).show()
        }

        var readButton = findViewById(R.id.restore_data) as Button
        readButton.setOnClickListener {
            var pref = getSharedPreferences("data", Context.MODE_PRIVATE)
            var name = pref.getString("name", "")
            var age = pref.getInt("age", 0)
            var married = pref.getBoolean("married", false)

            Toast.makeText(this, name + age + married, Toast.LENGTH_SHORT).show()

        }
    }
}
