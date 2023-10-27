package com.example.test

open class MyThread(val longInt: Long): Thread() {
    val longInt_1 = longInt
    init {
        start()

    }
    fun Sleep(){
        Thread.sleep(longInt_1)
    }

}