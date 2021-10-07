package com.hk.backgroundwork.HandlerLooperAgain

import android.os.Handler
import android.os.Looper

class ThreadOne : Thread() {
    var threadOneHandler : Handler? = null
    override fun run() {
        Looper.prepare()
        threadOneHandler = Looper.myLooper()?.let { Handler(it) }
        Looper.loop()
    }
}