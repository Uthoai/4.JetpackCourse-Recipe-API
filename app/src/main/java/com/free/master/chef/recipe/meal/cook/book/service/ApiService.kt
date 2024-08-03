package com.free.master.chef.recipe.meal.cook.book.service

import com.free.master.chef.recipe.meal.cook.book.service.data.CategoryResponse
import com.free.master.chef.recipe.meal.cook.book.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse
}

object ApiClient{
    private val retrofit = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val recipeService = retrofit.create(ApiService::class.java)
}

