package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.ui.homepage.HomepagePresenter
import com.raywenderlich.android.dagger.ui.homepage.HomepagePresenterImpl
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
}