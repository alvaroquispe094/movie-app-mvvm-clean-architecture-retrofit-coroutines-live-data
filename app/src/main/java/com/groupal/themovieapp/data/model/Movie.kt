package com.groupal.themovieapp.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("year") val year: String,
    @SerializedName("runtime") val runtime: String,
    @SerializedName("genres") val genres: List<String>,
    @SerializedName("director") val director: String,
    @SerializedName("actors") val actors: String,
    @SerializedName("plot") val plot: String,
    @SerializedName("posterUrl") val posterUrl: String

)

