package com.example.wangxiao.a21_webviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById(R.id.web_view) as WebView
        webView.settings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())
        webView.loadUrl("https://www.baidu.com/")
    }
}
