package com.example.catsfactsapplication.data.models.translate_api

import com.google.gson.annotations.SerializedName

data class Matche(
    @SerializedName("create-date")
    val create_date: String,
    @SerializedName("created-by")
    val created_by: String,
    val id: String,
    @SerializedName("last-update-date")
    val last_update_date: String,
    @SerializedName("last-updated-by")
    val last_updated_by: String,
    val match: Double,
    val quality: String,
    val reference: Any,
    val segment: String,
    val source: String,
    val subject: String,
    val target: String,
    val translation: String,
    @SerializedName("usage-count")
    val usage_count: Int
)