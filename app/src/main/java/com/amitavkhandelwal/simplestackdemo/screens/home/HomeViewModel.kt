package com.amitavkhandelwal.simplestackdemo.screens.home

import androidx.lifecycle.ViewModel
import com.amitavkhandelwal.simplestackdemo.screens.flow.FlowKey
import com.zhuinden.simplestack.Backstack
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val backStack: Backstack) : ViewModel() {

    fun startFlow() {
        backStack.goTo(FlowKey())
    }
}
