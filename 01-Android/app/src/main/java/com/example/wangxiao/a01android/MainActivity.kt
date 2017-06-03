package com.example.wangxiao.a01android

import android.content.ClipData
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
        val button: Button = findViewById(R.id.button_1) as Button

        button.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
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
