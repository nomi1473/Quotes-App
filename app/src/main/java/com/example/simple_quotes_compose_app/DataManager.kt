package com.example.simple_quotes_compose_app

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.simple_quotes_compose_app.model.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()

    var isDataLoaded  = mutableStateOf(false)

    var currentPage = mutableStateOf(Pages.LISTING)
    var currrentQuote : Quote? = null

    fun loadAssetFromFile(context : Context){

        val inputStream = context.assets.open("quotes.json")
        var size : Int = inputStream.available()
        var buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true


    }

    fun switchPages(quote : Quote?){
        if(currentPage.value == Pages.LISTING){
            currentPage.value = Pages.DETAIL
            currrentQuote = quote
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}