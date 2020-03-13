package com.amitavkhandelwal.simplestackdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * This will create a single instance of ViewModelFactory.
 *
 * https://github.com/android/architecture-samples/tree/dagger-android
 * https://proandroiddev.com/viewmodel-with-dagger2-architecture-components-2e06f06c9455
 */

@Singleton
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        viewModels[modelClass]?.get() as T
}
