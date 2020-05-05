package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.ui.homepage.HomepageActivity
import com.raywenderlich.android.dagger.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
// The component is used to connect objects to their dependencies,
@Component(modules = [
    AppModule::class,
    PresenterModule::class,
    NetworkModule::class,
    WikiModule::class
])
interface AppComponent {

    // The HomepageActivity class will require injection from AppComponent.
    fun inject(target: HomepageActivity)

    fun inject(target: SearchActivity)
}