package com.example.wangxiao.a12openfileoutput

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.io.*

class MainActivity : AppCompatActivity() {

    var edit: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edit = findViewById(R.id.editText) as EditText

        var inputText: String = loadFileContent() as String

        if (!TextUtils.isEmpty(inputText)) {
            edit?.setText(inputText, TextView.BufferType.NORMAL)
            edit?.setSelection(inputText.length)
            Toast.makeText(this, "Restoring succeeded", Toast.LENGTH_SHORT).show()
        }

        /// 读取内容
        val b = findViewById(R.id.btn) as Button
        b.setOnClickListener {
            Toast.makeText(this, loadFileContent(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        var content = edit?.text.toString()
        save(content)
    }

    /* 保存内容 */
    fun save(inputText: String) {

        var out: FileOutputStream? = null
        var writer: BufferedWriter? = null

        try {
            out = openFileOutput("data", Context.MODE_PRIVATE)
            writer = BufferedWriter(OutputStreamWriter(out))
            writer.write(inputText)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                if (writer != null) {
                    writer.close()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    fun loadFileContent(): String {

        var inin: FileInputStream? = null
        var reader: BufferedReader? = null

        var content = StringBuffer()

        try {
            inin = openFileInput("data")
            reader = BufferedReader(InputStreamReader(inin))
            var line = reader.readLine()

           while (line != null){
               content.append(line + "\n")
               line = reader.readLine()
           }

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return content.toString()
    }

}








