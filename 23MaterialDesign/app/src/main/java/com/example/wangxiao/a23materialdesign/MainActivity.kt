package com.example.wangxiao.a23materialdesign

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.widget.Button
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var mDrawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// toolbar
        val toolBar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolBar)

        ///
        mDrawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        var actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        /// 按钮
        val toolbar = findViewById(R.id.open_toolbar) as Button
        toolbar.setOnClickListener {
            val intent = Intent(this, ToolBarActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.backup ->
                    Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.delete ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            R.id.settings ->
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
            android.R.id.home ->
                mDrawerLayout?.openDrawer(GravityCompat.START)
            else ->
                    return false
        }
        return true
    }

}
