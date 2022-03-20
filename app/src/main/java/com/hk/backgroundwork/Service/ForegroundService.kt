package com.hk.backgroundwork.Service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.R
import android.app.Notification
import androidx.core.app.NotificationCompat
import com.hk.backgroundwork.App


class ForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notification: Notification = NotificationCompat.Builder(this, App.CHANNEL_ID)
            .setContentTitle("Forground Service")
            .setSmallIcon(R.drawable.ic_lock_idle_alarm)
            .build()
        startForeground(1, notification)
        return START_NOT_STICKY
    }
}