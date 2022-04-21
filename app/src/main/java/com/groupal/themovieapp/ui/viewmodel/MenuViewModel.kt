package com.groupal.themovieapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.domain.MenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val menuUseCase: MenuUseCase,
) : ViewModel() {

    val menus = MutableLiveData<List<Menu>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = menuUseCase()

            if (!result.isNullOrEmpty()) {
                menus.postValue(result)
                isLoading.postValue(false)
            }
        }
    }
}