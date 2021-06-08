package com.hk.backgroundwork

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.util.AttributeSet
import android.view.View
import com.hk.backgroundwork.HandlerLooper.BackgroundThread
import com.hk.backgroundwork.databinding.ActivityStartThreadBinding

class StartThreadActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityStartThreadBinding

    private var backgroundThread = BackgroundThread()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_thread)

        dataBinding.btnStartThread.setOnClickListener {
            //ThreadV1(5).start()


            //ThreadV2 class implements the Runnable interface. Thread class take the Runnable type of object in its constructor. That's why we implements Runnable interface in ThreadV2 class.
            //Thread(ThreadV2(5)).start()

            backgroundThread.start()
        }

        dataBinding.btnStopThread.setOnClickListener {
            backgroundThread.handler.looper.quit()
        }


        dataBinding.btnStartTask.setOnClickListener {

            //made a handler on UI thread which is associated with the looper of the background Thread
             var handlerThreadOnUIThread = Handler(backgroundThread.handler.looper)

            //handler of that particular thread/looper will post the task to the message queue of that looper
            backgroundThread.handler.post(object : Runnable {
                override fun run() {
                    for(i in 1..4) {
                        println("run : $i")
                        SystemClock.sleep(1000)
                    }
                }
            })
        }
    }
}