package com.groupal.themovieapp.data.service

import com.groupal.themovieapp.data.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieService {
    @GET("/Movie")
    suspend fun getAllMovies(): Response<List<Movie>>

    @GET("/Movie/{id}")
    suspend fun getMovie(@Path("id") id: String): Response<Movie>
}
