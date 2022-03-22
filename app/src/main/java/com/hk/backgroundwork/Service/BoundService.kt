package com.hk.backgroundwork.Service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService: Service() {
    private val binder = BoundServiceBinder()
    var number = 1

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }

    fun generateNumber() {
        number = 2
    }

    inner class BoundServiceBinder: Binder() {
        fun getService(): BoundService {
            return this@BoundService
        }
    }
}