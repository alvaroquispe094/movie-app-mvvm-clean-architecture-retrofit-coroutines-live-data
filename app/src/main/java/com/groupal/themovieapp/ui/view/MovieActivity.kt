package com.groupal.themovieapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.groupal.themovieapp.R
import com.groupal.themovieapp.data.model.Movie
import com.groupal.themovieapp.databinding.ActivityMenuBinding
import com.groupal.themovieapp.databinding.ActivityMovieBinding
import com.groupal.themovieapp.ui.viewmodel.MenuViewModel
import com.groupal.themovieapp.ui.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieActivity : AppCompatActivity(), MovieAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMovieBinding
    private val movieViewModel: MovieViewModel by viewModels()

    private lateinit var mRecyclerView : RecyclerView
    private val mAdapter : MovieAdapter = MovieAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        movieViewModel.onCreate2()

        mRecyclerView = binding.movieList
        mRecyclerView.setHasFixedSize(true)

//        mAdapter.setMenus(it)

        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mRecyclerView.adapter = mAdapter


        movieViewModel.movies.observe(this, Observer {
            //setear datos en recyleView

            mAdapter.setMovies(it)

        })
        movieViewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })

    }

    override fun onItemClick(movie: Movie) {
        //        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", movie.id)
        startActivity(intent)
    }

}