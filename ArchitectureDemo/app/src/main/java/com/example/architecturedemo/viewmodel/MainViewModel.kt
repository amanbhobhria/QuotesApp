package com.example.architecturedemo.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(val counter:Int): ViewModel() {
    var num=counter
    
    fun increment(): Int {
        return num++;
    }

    fun decemenet():Int{
        if(num==0)
        {
            return 0;
        }
        return num--;
    }
    
    
}