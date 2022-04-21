package com.groupal.themovieapp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://61912ee341928b001768ff93.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}