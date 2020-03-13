package com.amitavkhandelwal.simplestackdemo.screens.flow

import androidx.lifecycle.ViewModel
import com.zhuinden.simplestack.Backstack
import javax.inject.Inject

class FlowViewModel @Inject constructor(
    private val backstack: Backstack
//    private val resultHandler: ResultHandler
) : ViewModel() {

    interface ResultHandler {
        fun handleResult(data1: String, data2: String)
    }

    fun onCompleteFlow(data1: String, data2: String) {
//        resultHandler.handleResult(data1, data2)
        backstack.goBack()
    }
}
