package com.example.wangxiao.a21_webviewtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* 打开 WebView */
        val openWebView = findViewById(R.id.open_web_view) as Button
        openWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        /* 打开网络请求 */
        val sendRequest = findViewById(R.id.use_network) as Button
        sendRequest.setOnClickListener {
            val intent = Intent(this, NetWorkActivity::class.java)
            startActivity(intent)
        }

        /* 打开网络应用 */
        val networkUsage = findViewById(R.id.network_usage) as Button
        networkUsage.setOnClickListener {
            val intent = Intent(this, NetworkUsageActivity::class.java)
            startActivity(intent)
        }
    }
}
