package com.hk.backgroundwork.broadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadCastReceiver : BroadcastReceiver(){

    val TAG= "BroadCastReceiver"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(context, "android.intent.action.AIRPLANE_MODE", Toast.LENGTH_SHORT).show()
        }
        if(intent?.action.equals("monika.broadcast")) {
            Toast.makeText(context, "monika.broadcast", Toast.LENGTH_SHORT).show()
        }
    }
}