package com.groupal.themovieapp.di

import com.groupal.themovieapp.data.service.IMenuService
import com.groupal.themovieapp.data.service.IMovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://61912ee341928b001768ff93.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideIMenuService(retrofit: Retrofit):IMenuService{
        return retrofit.create(IMenuService::class.java)
    }

    @Singleton
    @Provides
    fun provideIMovieService(retrofit: Retrofit): IMovieService {
        return retrofit.create(IMovieService::class.java)
    }
}

