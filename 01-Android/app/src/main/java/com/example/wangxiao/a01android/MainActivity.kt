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

    /* 在活动第一次被创建的时候调用 */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Activity, ", "------ onCreate")
        setButton()
    }

    /* 这个方法在活动由不可见变为可见的时候调用 */
    override fun onStart() {
        super.onStart()
        Log.d("Activity", "------ onStart")
    }

    /* 这个方法在活动准备好和用户进行交互的时候调用 */
    override fun onResume() {
        super.onResume()
        Log.d("Activity", "------ onResume")
    }

    /* 这个方法在洗头准备去启动或者恢复另一个活动的时候调用 */
    override fun onPause() {
        super.onPause()
        Log.d("Activity", "------ onPause")
    }

    /* 这个方法在活动完全不可见的时候调用 */
    override fun onStop() {
        super.onStop()
        Log.d("Activity", "------ onStop")
    }

    /* 这个方法在活动被销毁之前调用 */
    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity", "------ onDestroy")
    }

    /* 这个方法在活动由停止状态变为运行状态之前调用 */
    override fun onRestart() {
        super.onRestart()
        Log.d("Activity", "------ onRestart")
    }

    /// 设置按钮点击事件
    fun setButton() {
        /// 点击按钮 Toast
        val button: Button = findViewById(R.id.button_1) as Button
        button.setOnClickListener {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        }

        /// 1. 显示方式
        /// 2. 隐示方式
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
