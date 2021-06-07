package com.hk.backgroundwork

import kotlin.math.sign

class ThreadV1(private val seconds: Int) : Thread(){

    override fun run() {
        for(i in 1..seconds) {
            sleep(1000)
        }
    }
}