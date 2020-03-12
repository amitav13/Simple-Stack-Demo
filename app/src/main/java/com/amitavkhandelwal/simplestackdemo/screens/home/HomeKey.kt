package com.amitavkhandelwal.simplestackdemo.screens.home

import com.amitavkhandelwal.simplestackdemo.navigation.BaseKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = HomeFragment()
}
