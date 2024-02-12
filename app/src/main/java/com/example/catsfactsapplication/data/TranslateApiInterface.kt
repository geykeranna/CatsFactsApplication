package com.example.catsfactsapplication.data

import com.example.catsfactsapplication.data.models.translate_api.TranslatedData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslateApiInterface {

    @GET("/get")
    suspend fun getTranslate(
        @Query("q") q: String,
        @Query("langpair") langpair: String = "en|ru"
    ) : Response<TranslatedData>
}