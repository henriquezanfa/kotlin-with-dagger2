package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.network.Homepage
import com.raywenderlich.android.dagger.network.Wiki
import com.raywenderlich.android.dagger.network.WikiApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WikiModule {
    @Provides
    @Singleton
    fun provideHomepage(api: WikiApi) = Homepage(api)

    @Provides
    @Singleton
    fun provideWiki(api: WikiApi) = Wiki(api)
}