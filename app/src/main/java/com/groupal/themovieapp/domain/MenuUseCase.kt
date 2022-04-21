package com.groupal.themovieapp.domain

import com.groupal.themovieapp.data.repository.MenuRepository
import javax.inject.Inject

class MenuUseCase @Inject constructor(private val repository: MenuRepository){
    suspend operator fun invoke() = repository.getAllMenus()
}