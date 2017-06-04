package com.example.wangxiao.a08_listview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {

    val list = mutableListOf<String>("Apple", "Banana", "首页", "剧集", "电影", "综艺", "音乐", "少儿", "来疯", "直播", "片库", "资讯", "拍客", "纪实", "公益", "体育")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list)
        val listView: ListView = findViewById(R.id.list_view) as ListView
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val string = list.get(position)
            Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
        }


    }
}
