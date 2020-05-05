package com.raywenderlich.android.dagger.dagger

import com.raywenderlich.android.dagger.network.WikiApi
import com.raywenderlich.android.dagger.utils.Const
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val NAME_BASE_STRING = "NAME_BASE_STRING"
    }

    @Provides
    @Named(NAME_BASE_STRING)
    fun provideBaseUrl() = "${Const.PROTOCOL}://${Const.LANGUAGE}.${Const.BASE_URL}"

    @Provides
    @Singleton
    fun provideHttpClient() = OkHttpClient()

    @Provides
    @Singleton
    fun provideRequestBuilder(@Named(NAME_BASE_STRING) baseUrl: String) =
            HttpUrl.parse(baseUrl)?.newBuilder()

    @Provides
    @Singleton
    fun provideWikiApi(client: OkHttpClient, requestBuilder: HttpUrl.Builder?) = WikiApi(client, requestBuilder)

}