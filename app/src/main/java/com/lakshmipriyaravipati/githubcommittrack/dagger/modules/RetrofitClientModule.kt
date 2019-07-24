package com.lakshmipriyaravipati.githubcommittrack.dagger.modules

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitClientModule {
    private val BASE_URL: String
        get() = "https://api.github.com/"

    @Provides
    @Singleton
    internal fun retrofitInstace() : Retrofit{
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    companion object{
        lateinit var retrofit: Retrofit
    }
}