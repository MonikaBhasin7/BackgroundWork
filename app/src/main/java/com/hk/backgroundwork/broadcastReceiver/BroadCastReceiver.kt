package com.hk.backgroundwork.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BroadCastReceiver : BroadcastReceiver(){

    val TAG= "BroadCastReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            println("${TAG} - android.intent.action.AIRPLANE_MODE")
        }
    }
}