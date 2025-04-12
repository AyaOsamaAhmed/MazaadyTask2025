package com.aya.mazaadytask.detailsMovie

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aya.mazaadytask.R
import com.aya.mazaadytask.base.BaseFragment
import com.aya.mazaadytask.databinding.DetailsMovieFragmentBinding
import com.aya.mazaadytask.listMovies.IMAGE_BASE
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsMovieFragment : BaseFragment<DetailsMovieFragmentBinding, DetailsMovieViewModel>() {


    override val viewModel: DetailsMovieViewModel by viewModels()

    private lateinit var nav: NavHostFragment
    private lateinit var navController: NavController


    override fun onFragmentReady() {
        setup()
        collect()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav =
            activity?.supportFragmentManager?.findFragmentById(R.id.main_layout) as NavHostFragment
        navController = nav.navController
    }

    private fun setup() {
        binding.imgBack.setOnClickListener {
                navController.popBackStack()
            }
        viewModel.onEvent(DetailsMovieEvent.GetMovieById(arguments?.getLong("id")?:0))
    }

    private fun collect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    val item = it.movie
                    binding.apply {
                        txTitle.text = item?.title
                        txReleaseDate.text = item?.releaseDate
                        txOverview.text = item?.overview
                        Glide.with(imgPoster)
                            .load("$IMAGE_BASE/${item?.posterPath}")
                            .into(imgPoster)
                    }
                }
            }
        }
    }



}