package com.groupal.themovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.data.model.Movie
import com.groupal.themovieapp.domain.GetMovieUseCase
import com.groupal.themovieapp.domain.MenuUseCase
import com.groupal.themovieapp.domain.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
        private val movieUseCase: MovieUseCase,
        private val getMovieUseCase: GetMovieUseCase,
) : ViewModel() {

    val movies = MutableLiveData<List<Movie>>()
    val movie = MutableLiveData<Movie>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate2() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = movieUseCase()

            if (!result.isNullOrEmpty()) {
                movies.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun getMovie(id:String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMovieUseCase(id)

            if (!result.equals(null)) {
                movie.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}