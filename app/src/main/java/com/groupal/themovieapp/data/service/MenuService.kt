package com.groupal.themovieapp.data.service

import com.groupal.themovieapp.data.model.Menu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Collections.emptyList
import javax.inject.Inject

class MenuService @Inject constructor(private val api:IMenuService){

    suspend fun getMenus(): List<Menu> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllMenus()
            response.body() ?: emptyList()
        }
    }

}