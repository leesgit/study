package com.lbc.practice.threadpractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.lbc.practice.threadpractice.R.id.textView
import android.os.SystemClock
import android.os.AsyncTask
import android.view.View
import com.lbc.practice.threadpractice.AsyncPracticeActivity.MyAsyncTask
import kotlinx.android.synthetic.main.activity_main.*




class AsyncPracticeActivity : AppCompatActivity() {


    var isFirst = true

    var asyncTask: MyAsyncTask? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        asyncTask = MyAsyncTask()

        btn_start.setOnClickListener(View.OnClickListener {
            if(isFirst){
                asyncTask?.isRun=true;
                asyncTask?.execute();
                isFirst=false;
            }else {
                asyncTask?.isRun=true;
            }
        })

        btn_stop.setOnClickListener(View.OnClickListener {
            asyncTask?.isRun=false;
        })


    }

    inner class MyAsyncTask : AsyncTask<Void, Int, String>() {
        var loopFlag = true
        var isRun: Boolean = false

        override fun doInBackground(vararg params: Void): String {
            var count = 10
            while (loopFlag) {
                SystemClock.sleep(1000)
                if (isRun) {
                    count--
                    publishProgress(count) //여기서 온프로그래스업데이트에 값 줌
                    if (count == 0) {
                        loopFlag = false
                    }
                }
            }
            return "Finish" // 여기서 온포스트엑시큐트에 값줌
        }

        protected override fun onProgressUpdate(vararg values: Int?) {
            textView.setText(values[0].toString())
        }

        override fun onPostExecute(s: String) {
            textView.setText(s)
        }
    }
}