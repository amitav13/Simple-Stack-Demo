package com.amitavkhandelwal.simplestackdemo.screens.splash

import com.amitavkhandelwal.simplestackdemo.navigation.BaseKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SplashKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = SplashFragment()
}
