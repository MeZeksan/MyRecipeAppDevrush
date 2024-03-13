package com.hfad.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

//создаем соединение с базовым URL и конвертируем его
private val retrofit = Retrofit.Builder().baseUrl("www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

//получаем доступ к сервисным методам
val recipeService = retrofit.create(ApiService::class.java)

interface ApiService{
    //@GET - используется для указания типа запроса на какой-либо сайт
    @GET("categories.php")
    //suspend - приостанавливает выполнение вызовов, в нашем случае вызова API.
    suspend fun getCategories():CategoriesResponce
}