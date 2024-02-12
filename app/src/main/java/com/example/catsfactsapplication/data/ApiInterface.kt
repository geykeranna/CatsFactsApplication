package com.example.catsfactsapplication.data

import com.example.catsfactsapplication.data.models.cats_api.CatFactsGetResponse
import com.example.catsfactsapplication.data.models.cats_api.CatFactsGetResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/facts")
    suspend fun getRandomFacts(): Response<CatFactsGetResponse>

    @GET("/fact")
    suspend fun getRandomFactItem(): Response<ArrayList<CatFactsGetResponseItem>>
}