package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.ui.homepage.HomepageActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
// The component is used to connect objects to their dependencies,
@Component(modules = [AppModule::class])
interface AppComponent {

    // The HomepageActivity class will require injection from AppComponent.
    fun inject(target: HomepageActivity)
}