package com.groupal.themovieapp.data.model

import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("id") val id: String,
    @SerializedName("code") val code: String,
    @SerializedName("description") val description: String
)
