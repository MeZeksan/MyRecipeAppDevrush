package com.hfad.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier
){
    val recipeViewModel:MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState
    Box(modifier = Modifier.fillMaxSize()){
        when {
            viewstate.loading ->
                CircularProgressIndicator(modifier.align(Alignment.Center))
            viewstate.error != null ->{
                Text(text = "ERROR OCCURED")
            }
            else ->{
                CategoryScreen(categories = viewstate.list)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories:List<Category>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ){
        items(categories){
            CategoryItem(category = it)
        }
    }
}

@Composable
fun CategoryItem(category: Category){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            //скачиваем картинку с интернета и передаем его с помощью implementation 
            painter = rememberAsyncImagePainter(model = category.strCategoryThumb), 
            contentDescription = category.strCategoryDescription,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}