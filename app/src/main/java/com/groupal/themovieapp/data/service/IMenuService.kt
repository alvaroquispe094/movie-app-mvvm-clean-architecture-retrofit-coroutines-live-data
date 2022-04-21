package com.groupal.themovieapp.data.service

import com.groupal.themovieapp.data.model.Menu
import retrofit2.Response
import retrofit2.http.GET

interface IMenuService {
    @GET("/Menu")
    suspend fun getAllMenus(): Response<List<Menu>>
}
