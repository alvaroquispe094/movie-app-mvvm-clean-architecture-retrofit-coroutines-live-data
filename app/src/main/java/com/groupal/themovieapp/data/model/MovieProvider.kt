package com.groupal.themovieapp.data.model

import retrofit2.Response
import java.util.Collections.emptyList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieProvider @Inject constructor() {
    var movies: List<Movie> = emptyList()
    lateinit var movie: Movie
}