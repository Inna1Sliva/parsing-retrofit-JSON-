package com.example.thisret.newModel


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("error")
    val error: Any,
    @SerializedName("result")
    val result: Result,
    @SerializedName("success")
    val success: Boolean
)