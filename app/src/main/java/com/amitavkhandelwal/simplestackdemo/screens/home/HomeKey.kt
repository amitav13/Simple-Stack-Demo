package com.amitavkhandelwal.simplestackdemo.screens.home

import com.amitavkhandelwal.simplestackdemo.navigation.BaseKey
import com.amitavkhandelwal.simplestackdemo.screens.flow.FlowViewModel
import com.amitavkhandelwal.simplestackdemo.viewmodels.HasServices
import com.amitavkhandelwal.simplestackdemo.viewmodels.add
import com.amitavkhandelwal.simplestackdemo.viewmodels.bindAs
import com.amitavkhandelwal.simplestackdemo.viewmodels.get
import com.zhuinden.simplestack.ServiceBinder
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeKey(private val placeholder: String = "") : BaseKey(), HasServices { // generate reliable `toString()` for no-args data class

    //inject HomeViewModel here?

    override fun createFragment() = HomeFragment()

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder) {
            //todo bind this viewmodel
            add(HomeViewModel())
            bindAs<FlowViewModel.ResultHandler>(get<HomeViewModel>())
        }
    }
}
