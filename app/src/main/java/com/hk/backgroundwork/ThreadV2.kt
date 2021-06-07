package com.hk.backgroundwork

class ThreadV2(val seconds: Int): Runnable {


    override fun run() {
        for(i in 1..seconds) {
            Thread.sleep(1000)
        }
    }
}