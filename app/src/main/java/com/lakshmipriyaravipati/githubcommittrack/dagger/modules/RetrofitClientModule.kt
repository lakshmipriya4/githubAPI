package com.lakshmipriyaravipati.githubcommittrack.dagger.modules

import com.lakshmipriyaravipati.githubcommittrack.service.CommitService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitClientModule {
    private val BASE_URL: String
        get() = "https://api.github.com/repos/"

    @Provides
    @Singleton
     fun retrofitInstace(): Retrofit {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun providesCommitService(): CommitService {
        return retrofitInstace().create(CommitService::class.java)
    }

    companion object {
        lateinit var retrofit: Retrofit
    }
}