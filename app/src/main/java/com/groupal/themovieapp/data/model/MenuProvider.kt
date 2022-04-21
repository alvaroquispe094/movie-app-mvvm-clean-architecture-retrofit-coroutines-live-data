package com.groupal.themovieapp.data.model

import java.util.Collections.emptyList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuProvider @Inject constructor() {
    var menus: List<Menu> = emptyList()
}