package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.network.Homepage
import com.raywenderlich.android.dagger.network.Wiki
import com.raywenderlich.android.dagger.ui.homepage.HomepagePresenter
import com.raywenderlich.android.dagger.ui.homepage.HomepagePresenterImpl
import com.raywenderlich.android.dagger.ui.search.EntryPresenter
import com.raywenderlich.android.dagger.ui.search.EntryPresenterImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {
    @Singleton
    @Provides
    //specifying that a HomepagePresenter will be provided,
    // and that the presenter returned will be the concrete implementation HomepagePresenterImpl.
    fun provideHomepagePresenter(homepage: Homepage): HomepagePresenter = HomepagePresenterImpl(homepage)

    @Singleton
    @Provides
    fun provideEntryPresenter(wiki: Wiki): EntryPresenter = EntryPresenterImpl(wiki)
}