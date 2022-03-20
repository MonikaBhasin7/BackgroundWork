package com.hk.backgroundwork

import android.app.Application
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build

object App : Application() {

    val CHANNEL_ID = "foregroundService"
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "foregroundService",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }
}