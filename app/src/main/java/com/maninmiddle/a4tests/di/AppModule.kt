package com.maninmiddle.a4tests.di

import com.maninmiddle.data.network.ApiService
import com.maninmiddle.data.repository.TestsRepositoryImpl
import com.maninmiddle.domain.repository.TestsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideTestsRepository(apiService: ApiService): TestsRepository {
        return TestsRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiService =
        Retrofit.Builder()
            .baseUrl("https://localhost:8080/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}