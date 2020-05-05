package com.raywenderlich.android.dagger.dagger

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// The @Module annotation tells Dagger that the AppModule
// class will provide dependencies for a part of the application
@Module
class AppModule(private val app: Application) {

    // The @Provides annotation tells Dagger that the method
    // provides a certain type of dependency, in this case, a Context object.
    // When a part of the app requests that Dagger inject a Context,
    // the @Provides annotation tells Dagger where to find it.
    @Provides
    // The @Singleton annotation tells Dagger that there should
    // only be a single instance of that dependency
    @Singleton
    fun provideContext(): Context = app
}