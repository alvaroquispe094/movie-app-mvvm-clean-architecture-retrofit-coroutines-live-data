package com.groupal.themovieapp.data.service

import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.data.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import java.util.Collections.emptyList
import javax.inject.Inject

class MovieService @Inject constructor(private val api:IMovieService){

    suspend fun getMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMovies()
            response.body() ?: emptyList()
        }
    }

    suspend fun getMovie(id: String): Movie {
        return withContext(Dispatchers.IO) {
            val response = api.getMovie(id)
            if(response.code().toString() == "404"){
                Movie(id= "3",
                title= "Crocodile Dundee",
                year= "1986",
                runtime= "97",
                genres= Arrays.asList("Adventure","Comedy"),
                director= "Peter Faiman",
                actors= "Paul Hogan, Linda Kozlowski, John Meillon, David Gulpilil",
                plot= "An American reporter goes to the Australian outback to meet an eccentric crocodile poacher and invites him to New York City.",
                posterUrl= "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg0MTU1MTg4NF5BMl5BanBnXkFtZTgwMDgzNzYxMTE@._V1_SX300.jpg"
                )
            }else{
                response.body()!!
            }

        }
    }

}