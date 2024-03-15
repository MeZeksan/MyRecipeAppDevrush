package com.hfad.myrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val idCategory: String,
    val strCategory:String,
    val strCategoryThumb : String,
    val strCategoryDescription:String
):Parcelable

//по сути это весь файл json который мы получили с сервера
data class CategoriesResponce(val categories:List<Category>)
