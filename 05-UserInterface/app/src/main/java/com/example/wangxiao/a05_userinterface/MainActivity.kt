package com.example.wangxiao.a05_userinterface

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.DialogPreference
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// TextView
        val button: Button = findViewById(R.id.textview) as Button
        button.setOnClickListener {
            val intent = Intent(this, TextViewActivity::class.java)
            startActivity(intent)
        }

        /// Button
        val button2: Button = findViewById(R.id.button) as Button
        button2.setOnClickListener {

        }

        /// 进度条
        val progressBar: ProgressBar = findViewById(R.id.progress_bar) as ProgressBar
        val progressControl: Button = findViewById(R.id.progress_control) as Button
        progressControl.setOnClickListener {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }

        val progress2: Button = findViewById(R.id.progress_control2) as Button
        progress2.setOnClickListener {
            var progress = progressBar.progress
            progress = progress + 10
            progressBar.progress = progress
        }

        /// 确认框
        val alertDialog: Button = findViewById(R.id.alert_dialog) as Button
        alertDialog.setOnClickListener {
            val alert:AlertDialog.Builder = AlertDialog.Builder(this) as AlertDialog.Builder
            alert.setTitle("This is a Dialog")
            alert.setMessage("SomeThing important.")
            alert.setCancelable(false)

            alert.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "点击了OK", Toast.LENGTH_SHORT).show()
            })

            alert.setNegativeButton("Cancle", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "点击了Cancle", Toast.LENGTH_SHORT).show()
            })

            alert.show()
        }

        /// Loading 框
        val progress: Button = findViewById(R.id.progress_dialog) as Button
        progress.setOnClickListener {
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("This is ProgressDialog")
            progressDialog.setMessage("Loading")
            progressDialog.setCancelable(true)
            progressDialog.show()
        }

        /// 切换图片
        val imgView: ImageView = findViewById(R.id.image_view) as ImageView
        val changeImage: Button = findViewById(R.id.change_button) as Button
        changeImage.setOnClickListener {
            imgView.setImageResource(R.mipmap.ic_launcher)
        }
    }
}









