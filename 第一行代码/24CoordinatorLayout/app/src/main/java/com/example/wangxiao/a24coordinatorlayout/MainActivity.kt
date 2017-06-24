package com.example.wangxiao.a24coordinatorlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.widget.Toast
import android.widget.FrameLayout
import android.view.ViewGroup
import android.app.Activity
import android.support.annotation.LayoutRes
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View


class MainActivity : AppCompatActivity() {

    val fruits = arrayOf<Fruit>(
            Fruit("AAAAAA", R.mipmap.ic_done),
            Fruit("BBBBBB", R.mipmap.ic_done),
            Fruit("AAACCC", R.mipmap.ic_launcher),
            Fruit("AAADDD", R.mipmap.ic_done),
            Fruit("11AAAA", R.mipmap.ic_launcher),
            Fruit("22BBBB", R.mipmap.ic_launcher),
            Fruit("33ACCC", R.mipmap.ic_launcher),
            Fruit("44ADDD", R.mipmap.ic_launcher),
            Fruit("AAAAAA", R.mipmap.ic_done),
            Fruit("BBBBBB", R.mipmap.ic_done),
            Fruit("AAACCC", R.mipmap.ic_launcher),
            Fruit("AAADDD", R.mipmap.ic_done)
    )

    var  adapter: FruitAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        adapter = FruitAdapter(fruits)
        recyclerView.adapter = adapter



        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            //            Toast.makeText(this, "HH", Toast.LENGTH_SHORT).show()
//            Snackbar.make(view, "哈哈哈", Snackbar.LENGTH_LONG).setAction("delete", null).show()

            Snackbar.make(view, "哈哈哈", Snackbar.LENGTH_LONG).setAction("delete") {
                Toast.makeText(this, "HH", Toast.LENGTH_SHORT).show()
            }.show()
        }

    }

    fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    fun getContentView(ac: Activity): View {
        val view = ac.window.decorView as ViewGroup
        val content = view.findViewById(android.R.id.content) as FrameLayout
        return content.getChildAt(0)
    }
}

public class Fruit(name: String, imageId: Int) {

    var name: String = ""
    var imageId: Int = 0

    init {
        this.name = name
        this.imageId = imageId
    }
}















