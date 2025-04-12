package com.aya.mazaadytask.base

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.aya.mazaadytask.extension.bindView


abstract class BaseActivity<B : ViewBinding, VM : ViewModel> : AppCompatActivity() {
    companion object {
        const val SCREEN_ID = "SCREEN_ID"
    }

    val baseShowProgress = ObservableBoolean()
    protected abstract val mViewModel: VM
    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindView()
    }

    fun setOpacityBackground(view: View, @ColorRes color: Int) {
        view.setBackgroundColor(
            try {
                ContextCompat.getColor(this, color)
            } catch (e: Resources.NotFoundException) {
                0
            }
        )
    }

}
