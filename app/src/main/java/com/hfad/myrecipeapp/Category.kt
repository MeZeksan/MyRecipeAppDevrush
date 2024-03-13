package com.hfad.myrecipeapp

data class Category(
    val idCategory: String,
    val strCategory:String,
    val strCategoryThumb : String,
    val strCategoryDescription:String
)

//по сути это весь файл json который мы получили с сервера
data class CategoriesResponce(val categories:List<Category>)
