package com.amitavkhandelwal.simplestackdemo.di

import android.app.Application
import android.content.res.Resources
import com.amitavkhandelwal.simplestackdemo.BackstackHolder
import com.zhuinden.simplestack.Backstack
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module for providing app-level services.
 * [AppComponent]
 */
@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    fun provideResources(application: Application): Resources = application.resources

    @Provides
    @Singleton
    fun provideBackstack(backstackHolder: BackstackHolder): Backstack {
        return backstackHolder.backstack
    }
}
