package com.example.wangxiao.a01android

import android.content.ClipData
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
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
        /// 点击按钮 Toast
        val button: Button = findViewById(R.id.button_1) as Button
        button.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        }

        /// 点击按钮 切换Activity
        val button2: Button = findViewById(R.id.open_activity) as Button
        button2.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    /* 添加按钮 */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    /* 设置菜单点击事件 */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        val i : MenuItem = item as MenuItem

        when (i.itemId) {

            R.id.finish ->
                    finish()

            R.id.add_item ->
                    Toast.makeText(this, i.title, Toast.LENGTH_SHORT).show()

            R.id.remove_item ->
                    Toast.makeText(this, i.title, Toast.LENGTH_SHORT).show()
        }

        return true
    }

}
