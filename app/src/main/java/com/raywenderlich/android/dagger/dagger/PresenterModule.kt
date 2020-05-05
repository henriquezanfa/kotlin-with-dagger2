package com.raywenderlich.android.dagger.dagger

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
    fun provideHomepagePresenter(): HomepagePresenter = HomepagePresenterImpl()

    @Singleton
    @Provides
    fun provideEntryPresenter(): EntryPresenter = EntryPresenterImpl()
}