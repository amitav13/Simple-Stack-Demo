package com.amitavkhandelwal.simplestackdemo.di

import android.app.Application
import com.amitavkhandelwal.simplestackdemo.MainActivity
import com.amitavkhandelwal.simplestackdemo.navigation.BaseFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class])
interface AppComponent {

    fun getApplication(): Application

    fun inject(baseFragment: BaseFragment)

    fun inject(mainActivity: MainActivity)
}
