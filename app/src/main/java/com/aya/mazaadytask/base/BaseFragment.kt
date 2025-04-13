package com.aya.mazaadytask.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.aya.mazaadytask.extension.bindView

abstract class BaseFragment<B : ViewBinding, VM : ViewModel> : Fragment() {


    abstract fun onFragmentReady()

    protected abstract val viewModel: VM

    private var _binding: B? = null
    lateinit var binding: B
    lateinit var nav: NavHostFragment
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindView()
        binding = _binding!!
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFragmentReady()
    }


}
