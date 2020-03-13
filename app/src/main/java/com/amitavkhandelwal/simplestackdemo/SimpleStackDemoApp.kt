package com.amitavkhandelwal.simplestackdemo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import com.amitavkhandelwal.simplestackdemo.di.AppComponent
import com.amitavkhandelwal.simplestackdemo.di.AppModule
import com.amitavkhandelwal.simplestackdemo.di.DaggerAppComponent

class SimpleStackDemoApp : Application() {

    companion object {
        lateinit var INSTANCE: SimpleStackDemoApp
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        INSTANCE = this
    }

}

val AppCompatActivity.app: SimpleStackDemoApp
    get() = application as SimpleStackDemoApp
