package com.jianhua.katdemo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class TimerViewModel(application: Application) : AndroidViewModel(application) {

    private var time : MutableLiveData<Long> = MutableLiveData<Long>()

    init {
         time.postValue(1000)
    }

    fun getTime() : MutableLiveData<Long>{
        return time
    }

    fun add() : Long? {
        return time.value?.plus(1)
    }

    override fun onCleared() {
        super.onCleared()
    }
}