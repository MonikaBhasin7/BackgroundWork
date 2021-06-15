package com.hk.backgroundwork

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.hk.backgroundwork.HandlerLooper.BackgroundThread
import com.hk.backgroundwork.broadcastReceiver.BroadCastReceiver
import com.hk.backgroundwork.databinding.ActivityStartThreadBinding


class StartThreadActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityStartThreadBinding
    lateinit var broadCastReceiver: BroadCastReceiver

    private var backgroundThread = BackgroundThread()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_thread)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_start_thread)
        dataBinding.btnStartThread.setOnClickListener {
            //ThreadV1(5).start()


            //ThreadV2 class implements the Runnable interface. Thread class take the Runnable type of object in its constructor. That's why we implements Runnable interface in ThreadV2 class.
            //Thread(ThreadV2(5)).start()
            backgroundThread.start()
        }

        dataBinding.btnStopThread.setOnClickListener {
            backgroundThread.handler.looper.quit()
        }


        var customizedThread = CustomizedThread()
        customizedThread.start()
        dataBinding.btnStartCustomizedThread.setOnClickListener {
            customizedThread.addTask(object : Runnable {
                override fun run() {
                    for (i in 1..4) {
                        println("run : $i")
                        SystemClock.sleep(1000)
                    }
                }

            })
        }

        dataBinding.btnStartTask.setOnClickListener {

            //made a handler on UI thread which is associated with the looper of the background Thread
             var handlerThreadOnUIThread = Handler(Looper.getMainLooper())
            //handler of that particular thread/looper will post the task to the message queue of that looper
            backgroundThread.handler.post(object : Runnable {
                override fun run() {
                    for (i in 1..4) {
                        println("run : $i")
                        SystemClock.sleep(1000)
                    }

                    handlerThreadOnUIThread.post(object : Runnable {
                        override fun run() {
                            dataBinding.tvTaskDone.text = "Task Done"
                        }

                    })
                }
            })
        }
        dataBinding.btnSendBroadcast.setOnClickListener {
            val intent = Intent("monika.broadcast")
            intent.putExtra("monika.broadcast.data", "Broadcast received")
            sendBroadcast(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        //Dynamic Broadcast Receiver
        broadCastReceiver = BroadCastReceiver()
        var intentFilter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(broadCastReceiver, intentFilter)

        registerReceiver(broadCastReceiver, IntentFilter("monika.broadcast"))
    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(broadCastReceiver);
    }
}