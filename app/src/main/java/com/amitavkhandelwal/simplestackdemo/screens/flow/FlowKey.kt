package com.amitavkhandelwal.simplestackdemo.screens.flow

import com.amitavkhandelwal.simplestackdemo.navigation.BaseKey
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlowKey(private val placeholder: String = "") : BaseKey() { // generate reliable `toString()` for no-args data class
    override fun createFragment() = FlowFragment()
}
