package com.arjun.livedatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.arjun.livedatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val quoteData = Quote("it is oneWay Text, \nbelow You can see the example of two way")
        binding.oneWay = quoteData

//        mainViewModel.factsLiveDataObject.observe(this){
//            val quoteData = Quote(it)
//            binding.oneWay = quoteData
//        }

        binding.mainViewModel = mainViewModel
        binding.lifecycleOwner = this
    }
}