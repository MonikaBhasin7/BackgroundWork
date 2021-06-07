package com.hk.backgroundwork

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.hk.backgroundwork.databinding.ActivityStartThreadBinding

class StartThreadActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityStartThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_thread)

        dataBinding.btnStartThread.setOnClickListener {
            ThreadV1(5).start()
        }
    }
}