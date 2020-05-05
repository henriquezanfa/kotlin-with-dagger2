package com.raywenderlich.android.dagger.dagger

import dagger.Component
import javax.inject.Singleton

@Singleton
// The component is used to connect objects to their dependencies,
@Component(modules = [AppModule::class])
interface AppComponent