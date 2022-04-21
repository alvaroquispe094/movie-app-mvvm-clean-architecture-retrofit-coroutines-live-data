package com.groupal.themovieapp.data.repository

import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.data.model.MenuProvider
import com.groupal.themovieapp.data.service.MenuService
import javax.inject.Inject

class MenuRepository @Inject constructor(
    private val api: MenuService,
    private val menuProvider: MenuProvider
){
    suspend fun getAllMenus(): List<Menu> {
        val response = api.getMenus()
        menuProvider.menus = response
        return response
    }
}