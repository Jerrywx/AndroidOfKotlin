package com.example.wangxiao.a24coordinatorlayout

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

/**
 * Created by wangxiao on 2017/6/24.
 */


public class FruitAdapter: RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    var mContext: Context? = null
    var mFruitList: Array<Fruit>? = null

    constructor(fruitLsit: Array<Fruit>) {
        mFruitList = fruitLsit
    }

//    class ViewHolder: RecyclerView.ViewHolder(view: View) {
    class ViewHolder : RecyclerView.ViewHolder {
        var cardView: CardView? = null
        var fruitImage: ImageView? = null
        var fruitName: TextView? = null

        constructor(view: View) : super(view) {
            cardView = view as CardView
            fruitImage = view.findViewById(R.id.fruit_image) as ImageView
            fruitName = view.findViewById(R.id.fruit_name) as TextView
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup?, p1: Int): ViewHolder {

        if (mContext == null) {
            mContext = p0?.context
        }
        val view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item,p0,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder?, p1: Int) {
        val fruit = mFruitList?.get(p1)
        p0?.fruitName?.setText(fruit?.name)
        Glide.with(mContext).load(fruit?.imageId).into(p0?.fruitImage)
    }

//    override fun onBindViewHolder(holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
////        super.onBindViewHolder(holder, position, payloads)
//        val fruit = mFruitList?.get(position)
//        holder?.fruitName?.setText(fruit?.name)
//        Glide.with(mContext).load(fruit?.imageId).into(holder?.fruitImage)
//    }

    override fun getItemCount(): Int {
        var size = 0
        if (mFruitList != null) {
            size = mFruitList?.count() as Int
        }
        return size
    }
}