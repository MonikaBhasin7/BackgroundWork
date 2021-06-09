package com.hk.backgroundwork.HandlerLooper

import android.os.Handler
import android.os.Looper
import android.os.Message

class BackgroundThread : Thread(){

    companion object {
        private const val TAG = "BackgroundThread"
    }

    lateinit var handler : Handler



    override fun run() {
        //attaching the looper with the thread and making of messageQueue also takes place.
        Looper.prepare()
        //associate the handler with the looper of the thread
        handler = NewHandler()
        handler.obtainMessage()
        //It loops around the message queue.
        Looper.loop()

        println("It will not execute because the looper has started looping the message queue in the above line.")

    }

    class NewHandler: Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
        }
    }
}