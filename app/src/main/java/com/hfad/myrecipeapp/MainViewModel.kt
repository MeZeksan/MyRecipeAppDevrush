package com.hfad.myrecipeapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    //переменная, которая хранит состояние категорий
    private val _categoriesState = mutableStateOf(RecipeState())
     val categoriesState : State<RecipeState> = _categoriesState

    init{
        fetchCategories()
    }


    //видимо является одним из корутинов Котлин
    //загрузка функций происходит в фоновом режиме
    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                //переменная "ответ" которая по сути получает данные с сайта
                // адрес сайта, с которого берем информацию получится https://www.themealdb.com/api/json/v1/1/categories.php
                val responce = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = responce.categories,
                    loading = false,
                    error = null
                )

            }catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error fetching Categories ${e.message}"
                )
            }
        }
    }

    //состояние категорий, то есть загружается или нет, есть ошибка и list с категориями
    data class RecipeState(
        val loading:Boolean = true,
        val list :List<Category> = emptyList(),
        val error:String? = null
    )
}