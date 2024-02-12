package com.example.catsfactsapplication.utils

import com.example.catsfactsapplication.data.ApiInterface
import com.example.catsfactsapplication.data.TranslateApiInterface
import com.example.catsfactsapplication.utils.Utils.BASE_URL
import com.example.catsfactsapplication.utils.Utils.TRANSLATE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    val translateApi: TranslateApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(TRANSLATE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TranslateApiInterface::class.java)
    }
}