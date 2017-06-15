package com.example.wangxiao.a23materialdesign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// toolbar
        val toolBar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)

        /// 按钮
        val toolbar = findViewById(R.id.open_toolbar) as Button
        toolbar.setOnClickListener {
            val intent = Intent(this, ToolBarActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        return super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        return super.onOptionsItemSelected(item)

        when (item?.itemId) {

            R.id.backup ->
                    Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.delete ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.settings ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            else ->
                    return false
        }

        return true
    }

}
