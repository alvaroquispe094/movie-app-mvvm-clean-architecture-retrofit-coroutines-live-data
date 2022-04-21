package com.groupal.themovieapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.groupal.themovieapp.R
import com.groupal.themovieapp.data.model.Movie
import com.groupal.themovieapp.databinding.ActivityDetailBinding
import com.groupal.themovieapp.databinding.ActivityMenuBinding
import com.groupal.themovieapp.ui.viewmodel.MenuViewModel
import com.groupal.themovieapp.ui.viewmodel.MovieViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val movieViewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getStringExtra("id").toString()

        movieViewModel.getMovie(id)

        movieViewModel.movie.observe(this, Observer {
            //setear datos en recyleView
            val control = it.posterUrl.isNotBlank()

            if(control){
                Picasso.get()
                    .load(it.posterUrl)
                    .placeholder(R.drawable.test)
                    .into(binding.includeHeaderMovie.imgCharacter)
            }else{
                Picasso.get()
                    .load(R.drawable.test)
                    .placeholder(R.drawable.test)
                    .into(binding.includeHeaderMovie.imgCharacter)
            }

            binding.includeInfoMovie.title.text = it.title
            binding.includeInfoMovie.info.text = it.year+"        "+it.runtime+" min."+"        "+it.genres.toString()
            binding.includeInfoMovie.plot.text = it.plot
            binding.includeInfoMovie.director.text = "Director: " +it.director
            binding.includeInfoMovie.actors.text = "Cast: " + it.actors

        })
        movieViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })


    }
}