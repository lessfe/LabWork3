package com.example.test

import android.content.ClipData
import android.content.ClipData.Item
import android.provider.Telephony.Threads
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.concurrent.thread
import android.util.Log

class DataModel: ViewModel() {
    open val mutableValThread = MutableLiveData<Int>()
    init {
        mutableValThread.value = 3_000
    }

    private val mutableSelectedItem = MutableLiveData<Int>()

    val nonNullableInt: Int = mutableValThread.value!!
    val LongInt = nonNullableInt.toLong()

    val myThread = MyThread(LongInt)
       val selectedItem: LiveData<Int> get() = mutableSelectedItem

    fun selectItem(int: Int){
        mutableSelectedItem.value = int

    }

}