package com.amitavkhandelwal.simplestackdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amitavkhandelwal.simplestackdemo.screens.home.HomeViewModel
import com.amitavkhandelwal.simplestackdemo.screens.splash.SplashViewModel
import com.careclues.patient.di.ViewModelFactory
import com.careclues.patient.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * https://github.com/android/architecture-samples/tree/dagger-android
 * https://proandroiddev.com/viewmodel-with-dagger2-architecture-components-2e06f06c9455
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(viewModel: HomeViewModel): ViewModel

}
