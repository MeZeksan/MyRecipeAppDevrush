package com.hfad.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//создаем соединение с базовым URL и конвертируем его
private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//получаем доступ к сервисным методам
val recipeService = retrofit.create(ApiService::class.java)


interface ApiService{
    //@GET - используется для указания типа запроса на какой-либо сайт
    //suspend - приостанавливает выполнение вызовов, в нашем случае вызова API.
    @GET("categories.php")
    suspend fun getCategories():CategoriesResponce
}