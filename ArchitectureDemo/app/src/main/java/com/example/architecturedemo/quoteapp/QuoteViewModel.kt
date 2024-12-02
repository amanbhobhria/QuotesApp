package com.example.architecturedemo.quoteapp

import Quote
import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class QuoteViewModel(private val context: Context): ViewModel() {
     var index:Int=0;
    var quoteList: Array<Quote> = emptyArray()


    init {
        quoteList=loadQuotefromAsset()
    }


    private fun loadQuotefromAsset(): Array<Quote> {
     val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return Gson().fromJson(json, Array<Quote>::class.java)
    }


    fun showQuote() = quoteList[index]


    fun nextQuote() =quoteList[++index]




    fun prevQuote()=  quoteList[--index]



}