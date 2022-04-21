package com.groupal.themovieapp.domain

import com.groupal.themovieapp.data.repository.MenuRepository
import com.groupal.themovieapp.data.repository.MovieRepository
import javax.inject.Inject

class MovieUseCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke() = repository.getAllMovies()
}

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository){
    suspend operator fun invoke(id: String) = repository.getMovie(id)
}