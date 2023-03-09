package com.arjun.livedatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val factsLiveDataObject = MutableLiveData<String>("This is a fact")

//    val factLiveData : LiveData<String>
//    get() = factsLiveDataObject

    fun updatedData(){
        factsLiveDataObject.value = "This task has been updated"
    }

}