package com.lbc.practice.threadpractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import com.lbc.practice.threadpractice.R.id.textView


class MainActivity : AppCompatActivity() {

    var loop = true
    var isFirst = true
    var isRun = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var thread = MyThread()

        btn_start.setOnClickListener(View.OnClickListener {
            if (isFirst) {
                isFirst = false;
                isRun = true;
                thread.start();
            } else {
                isRun = true;
            }
        })

        btn_stop.setOnClickListener(View.OnClickListener {
            isRun = false;
        })

        btn_move.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AsyncPracticeActivity::class.java)
            startActivity(intent)
        })
    }

    internal inner class MyThread : Thread() { //MainThread를 이용하여 UI에 접근

        var handler: Handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                if (msg.what == 1) {  //메시지의 what 값에 따라 텍스트 변경
                    textView.text = msg.arg1.toString()
                } else if (msg.what == 2) {
                    textView.text = msg.obj as String
                }
            }
        }
        override fun run() {
            try {
                var count = 10
                while (loop) {
                    Thread.sleep(1000)
                    if (isRun) {
                        count--
                        var message = Message()
                        message.what = 1   //what값
                        message.arg1 = count
                        handler.sendMessage(message)
                        if (count == 0) {
                            message = Message()
                            message.what = 2  //what값
                            message.obj = "Finish"
                            handler.sendMessage(message)
                            loop = false
                        }
                    }
                }
            } catch (e: Exception) {

            }

        }
    }
}
