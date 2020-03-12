package com.amitavkhandelwal.simplestackdemo.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amitavkhandelwal.simplestackdemo.screens.home.HomeKey
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.StateChange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val backstack: Backstack
): ViewModel() {

    fun onViewReady() {
        viewModelScope.launch {
            delay(TimeUnit.SECONDS.toMillis(2))
            backstack.setHistory(History.of(HomeKey()), StateChange.REPLACE)
        }
    }

}
