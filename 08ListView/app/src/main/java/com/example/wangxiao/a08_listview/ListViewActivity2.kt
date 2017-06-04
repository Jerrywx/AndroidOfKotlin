package com.example.wangxiao.a08_listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import Fruit
import FruitAdapter
import android.widget.ArrayAdapter
import android.widget.ListView

class ListViewActivity2 : AppCompatActivity() {

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
        setContentView(R.layout.activity_list_view2)

        val adapter = FruitAdapter(this, R.layout.fruit_item, R.id.fruit_name, fruitList)
        val listView: ListView = findViewById(R.id.list_view2) as ListView
        listView.adapter = adapter

    }



}
