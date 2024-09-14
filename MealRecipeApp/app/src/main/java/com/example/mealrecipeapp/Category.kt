package com.example.mealrecipeapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

// parcelize will take care of this object into more convenient format to passing data using navigation
@Parcelize
data class Category(
    val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String
) : Parcelable

data class CategoryResponse(val categories: List<Category>)
