package com.example.catsfactsapplication.data.models.translate_api

import com.google.gson.annotations.SerializedName

data class TranslatedData(
    val exception_code: Any,
    val matches: List<Matche>,
    val mtLangSupported: Any,
    val quotaFinished: Boolean,
    val responderId: Any,
    val responseData: ResponseData,
    val responseDetails: String,
    val responseStatus: Int
)