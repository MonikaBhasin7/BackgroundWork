package com.hk.backgroundwork

import java.util.*
import java.util.concurrent.atomic.AtomicBoolean

class CustomizedThread : Thread(){


    private var messageQueue : Queue<Runnable>? = LinkedList()
    private var isAlive : AtomicBoolean = AtomicBoolean(true)

    override fun run() {
        while (isAlive.get()) {
            if(!messageQueue.isNullOrEmpty()) {
                messageQueue!!.poll().run()
            }
        }
    }

    fun addTask(task: Runnable) {
        messageQueue?.add(task)
    }

    fun stopThread() {
        isAlive.set(false)
        messageQueue?.clear()
    }
}