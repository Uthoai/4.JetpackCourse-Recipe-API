package com.free.master.chef.recipe.meal.cook.book.service.data

import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CategoryData(
    @SerializedName("idCategory")
    val idCategory: String? = null,
    @SerializedName("strCategory")
    val strCategory: String? = null,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null
)

@Keep
data class CategoryResponse(
    @SerializedName("categories")
    val categoryData: List<CategoryData>
)
