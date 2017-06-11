package com.example.wangxiao.a21_webviewtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetWorkActivity : AppCompatActivity() {

    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_net_work)

        val sendRequest = findViewById(R.id.send_request) as Button
        sendRequest.setOnClickListener {
//            sendRequestWithHttpURLConnection()
            sendRequestWithOkHttp()
        }

        textView = findViewById(R.id.text_View) as TextView

    }

    /* 使用OkHttp */
    fun sendRequestWithOkHttp() {

        Thread(Runnable {

            try {
                var client = OkHttpClient()
                var request: Request = Request.Builder()
                        .url("https://www.baidu.com")
                        .build()
                var response = client.newCall(request).execute()
                var responseData: String = response.body()?.string() as String
                showResponse(responseData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }).start()
    }

    /* 发起网络请求 */
    fun sendRequestWithHttpURLConnection() {

        Thread(Runnable {

            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null

            try {

                val url: URL = URL("https://www.baidu.com/")
                connection = url.openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.connectTimeout = 8000
                connection.readTimeout = 8000
                var input: InputStream = connection.inputStream

                reader = BufferedReader(InputStreamReader(input))
                var response = StringBuffer()
                var line: String? = reader.readLine()

                while (line != null) {
                    response.append(line)
                    line = reader.readLine()
                }

                showResponse(response.toString())
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                if (reader != null) {
                    try {
                        reader.close()
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    if (connection != null) {
                        connection.disconnect()
                    }
                }
            }
        }).start()
    }

    fun showResponse(response: String) {
        runOnUiThread {
            textView?.text = response
        }
    }

}









