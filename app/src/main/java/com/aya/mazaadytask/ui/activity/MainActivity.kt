package com.aya.mazaadytask.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.aya.mazaadytask.R
import com.aya.mazaadytask.base.BaseActivity
import com.aya.mazaadytask.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    override val mViewModel: MainViewModel by viewModels()

    private lateinit var nav: NavHostFragment
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nav = supportFragmentManager.findFragmentById(R.id.main_layout) as NavHostFragment
        navController = nav.navController


    }

}
