package com.hfad.myrecipeapp

data class Category(
    val idCategory: String,
    val strCategory:String,
    val strCategoryThumb : String,
    val strCategoryDescription:String
)

data class CategoriesResponce(val categories:List<Category>)
