package com.hk.backgroundwork

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import androidx.databinding.DataBindingUtil
import com.hk.backgroundwork.Service.BoundService
import com.hk.backgroundwork.databinding.ActivityFirstBinding
import com.hk.backgroundwork.databinding.ActivityStartThreadBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var mService: BoundService
    private var mBound : Boolean = false
    private var dataBinding: ActivityFirstBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        bindService(Intent(this, BoundService::class.java), connection, Context.BIND_AUTO_CREATE)
        dataBinding?.btnSecondActiivty?.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mService = (service as BoundService.BoundServiceBinder).getService()
            mBound = true
            dataBinding?.btnGenerate?.setOnClickListener {
                mService.generateNumber()
            }
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            mBound = false
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
        mBound = false
    }
}