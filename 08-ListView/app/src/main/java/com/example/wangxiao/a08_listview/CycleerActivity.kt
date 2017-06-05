package com.example.wangxiao.a08_listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import Fruit
import FruitAdapter2
import android.support.v7.widget.StaggeredGridLayoutManager

class CycleerActivity : AppCompatActivity() {

    val fruitList = mutableListOf<Fruit>(Fruit("AAAA", R.mipmap.ic_launcher),
            Fruit("AAAA", R.mipmap.ic_launcher),
            Fruit("BBBB", R.mipmap.ic_launcher),
            Fruit("CCCC", R.mipmap.ic_launcher),
            Fruit("DDDD", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("AAAA", R.mipmap.ic_launcher),
            Fruit("BBBB", R.mipmap.ic_launcher),
            Fruit("CCCC", R.mipmap.ic_launcher),
            Fruit("DDDD", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher),
            Fruit("EEEE", R.mipmap.ic_launcher))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cycleer)

        var recyclerView = findViewById(R.id.recycler_view) as RecyclerView

//        var layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        recyclerView.layoutManager = layoutManager
        var adapter = FruitAdapter2(fruitList)
        recyclerView.adapter = adapter

    }
}
