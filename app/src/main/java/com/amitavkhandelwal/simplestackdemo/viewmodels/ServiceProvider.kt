package com.amitavkhandelwal.simplestackdemo.viewmodels

import com.amitavkhandelwal.simplestackdemo.navigation.BaseKey
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.simplestack.ServiceBinder

class ServiceProvider : ScopedServices {
    override fun bindServices(serviceBinder: ServiceBinder) {
        val key = serviceBinder.getKey<BaseKey>()

        val scope = serviceBinder.scopeTag

        if (key is HasServices && key.scopeTag == scope) {
            key.bindServices(serviceBinder) // screen-bound shared services
        }
    }
}
