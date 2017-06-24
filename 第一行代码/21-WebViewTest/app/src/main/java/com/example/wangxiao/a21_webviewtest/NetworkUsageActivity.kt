package com.example.wangxiao.a21_webviewtest

import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer

class NetworkUsageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_usage)


        val send = findViewById(R.id.sender)
        send.setOnClickListener {

            Thread(Runnable {

            })

            HttpUtil.sendHttpRequest("https://www.baidu.com/") { response, e, isSuccess ->
                println("=============${response} ----${Thread.currentThread()}")

                runOnUiThread {
                    if (isSuccess) {
                        Toast.makeText(this, "成功！！！", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "失败！！！", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }

    fun  callBack(back: (content: String) -> Unit) {
        back("哈哈")
    }

}

/* 网络工具类 */
public class HttpUtil {

    companion object {

        public fun sendHttpRequest(address: String, onFinish: (response: String, e: Exception?, isSuccess: Boolean) -> Unit) {

            /* 创建子线程请求网络 */
            Thread(Runnable {

                var connection: HttpURLConnection? = null
                try {
                    var url = URL(address)
                    connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connectTimeout = 8000
                    connection.readTimeout = 8000000
                    connection.doInput = true
                    connection.doOutput = true
                    var input: InputStream = connection.inputStream
                    var reader: BufferedReader = BufferedReader(InputStreamReader(input))

                    println("==== 请求的内容111")
                    var response: StringBuilder = StringBuilder()



                    var line: String = reader.readLine()
                    println("==== 请求的内容AAA ${line}")
                    response.append(line)
                    line = reader.readLine()
                    println("==== 请求的内容AAA ${line}")
                    response.append(line)

//                    line = reader.readLine()
//                    println("==== 请求的内容AAA ${line}")
//                    response.append(line)


//                    println("==== 请求的内容222")
//                    while (line != null) {
//                        response.append(line)
//                        println("==== 请求的内容AAA ${reader}")
//                        line = reader.readLine()
//                    }

                    println("==== 请求的内容 ${response.toString()}")
                    if (onFinish != null) {
                        onFinish(response.toString(), null, true)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    if (onFinish != null) {
                        onFinish("", e, false)
                    }
                } finally {
                    if (connection != null) {
                        connection.disconnect()
                    }
                }
            }).start()
        }
    }
}

/* 全局获取 Context */
public class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        myContext = applicationContext
    }

    companion object {

        public var myContext: Context? = null
        public fun getContext(): Context {
            return myContext as Context
        }
    }

}
