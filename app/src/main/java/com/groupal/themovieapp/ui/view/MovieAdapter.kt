package com.groupal.themovieapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.annotations.SerializedName
import com.groupal.themovieapp.R
import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.data.model.Movie
import com.squareup.picasso.Picasso

class MovieAdapter(val listener: MovieAdapter.OnItemClickListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent, false);
        return MovieViewHolder(view);
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.movie = item
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setMovies(movies: List<Movie>){
        items.clear()
        items.addAll(movies)
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        var movie: Movie? = null
            set(value){
                value?.let {
                    //averiguar como usar viewBinding en adapter que hereda de Recyclerview en vez de fragment o activity
                    //val bindingDetail = ActivityDetailBinding.inflate(layoutInflater)

                    itemView.findViewById<TextView>(R.id.title).text = value?.title;
                    val control = value.posterUrl.isNotBlank()

                    if(control){
                    Picasso.get()
                            .load(value.posterUrl).error(R.drawable.test)
                            .placeholder(R.drawable.test)
                            .into(itemView.findViewById<ImageView>(R.id.image))

                    }else{
                        Picasso.get()
                                .load(R.drawable.test)
                                .placeholder(R.drawable.test)
                                .into(itemView.findViewById<ImageView>(R.id.image))
                    }

                }
                field = value
            }

            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
    //                listener?.invoke(menu as Menu, bindingAdapterPosition)
                    movie?.let { listener.onItemClick(movie!!) }
                }
            }
    }

    interface OnItemClickListener {
        fun onItemClick(movie: Movie)
    }
}