package com.aya.mazaadytask.activity

import com.aya.mazaadytask.base.Action
import com.aya.mazaadytask.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


sealed class MainAction() : Action

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {


}