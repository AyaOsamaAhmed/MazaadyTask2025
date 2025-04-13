package com.aya.mazaadytask.listMovies

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.aya.mazaadytask.R
import com.aya.mazaadytask.base.BaseFragment
import com.aya.mazaadytask.databinding.ListMovieFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListMovieFragment : BaseFragment<ListMovieFragmentBinding, ListMoviesViewModel>() {

    override val viewModel: ListMoviesViewModel by viewModels()

    private lateinit var nav: NavHostFragment
    private lateinit var navController: NavController

    private val adapter by lazy {
        MoviesAdapter(
            onItemClick = {
                //Navigate to Details Screen here...
                navController.navigate(R.id.ListMovieFragment_to_DetailsMovieFragment,Bundle().apply {
                    putLong("id", it.id)}
                )
            },
            onFavoriteClick = {
                viewModel.onEvent(ListMoviesEvent.MarkMovieAsFavorite(it.id, it.isFavorite))
            }
        )
    }

    override fun onFragmentReady() {
        setup()
        collect()
        viewModel.onEvent(ListMoviesEvent.GetMovies)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav =
            activity?.supportFragmentManager?.findFragmentById(R.id.main_layout) as NavHostFragment
        navController = nav.navController
    }

    private fun setup() {
        binding.apply {
            moviesRV.adapter = adapter
            moviesRV.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            sortLayout.setOnClickListener {
                viewModel.onEvent(ListMoviesEvent.MarkSortGridLayout(!viewModel.state.value.isGridSortLayout))
            }
        }
    }

    private fun collect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    binding.progressBar.isVisible = it.isLoading

                    if (it.isGridSortLayout) {
                        binding.sortLayout.setImageResource(R.drawable.ic_grid_view)
                        binding.moviesRV.layoutManager =
                            GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL , false)
                    } else {
                        binding.sortLayout.setImageResource(R.drawable.ic_list_view)
                        binding.moviesRV.layoutManager =
                            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    }
                    it.moviesPaging?.let { movies ->
                        adapter.submitData(lifecycle, movies)
                    }
                }
            }
        }
    }

}