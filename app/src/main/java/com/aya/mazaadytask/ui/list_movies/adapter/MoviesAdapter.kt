package com.aya.mazaadytask.ui.list_movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.data.database.MovieEntity
import com.aya.mazaadytask.R
import com.aya.mazaadytask.databinding.ItemMovieVerticalBinding
import com.bumptech.glide.Glide

const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500"

class MoviesAdapter(
    private val onItemClick: (MovieEntity) -> Unit,
    private val onFavoriteClick: (MovieEntity) -> Unit
) :
    PagingDataAdapter<MovieEntity, MoviesAdapter.MovieItemViewHolder>(MoviesDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        return MovieItemViewHolder(
            ItemMovieVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MovieItemViewHolder(
        private val binding: ItemMovieVerticalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieEntity) {
            binding.txTitle.text = item.title
            binding.txReleaseDate.text = item.releaseDate
            Glide.with(binding.imgPoster)
                .load("$IMAGE_BASE/${item.posterPath}")
                .into(binding.imgPoster)

            binding.imgFav.setImageResource(
                if (item.isFavorite) {
                    R.drawable.ic_favorite
                } else {
                    R.drawable.ic_no_favorite
                }
            )
            binding.imgFav.setOnClickListener {
                onFavoriteClick(item)
            }

            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    private class MoviesDiffUtil : DiffUtil.ItemCallback<MovieEntity>() {

        override fun areItemsTheSame(
            oldItem: MovieEntity,
            newItem: MovieEntity
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieEntity,
            newItem: MovieEntity
        ): Boolean {
            return oldItem == newItem
        }
    }
}


