package com.example.mealoftheday.model.randomMeal


import com.google.gson.annotations.SerializedName

data class RandomMeal(
    @SerializedName("meals")
    val meals: List<Meal>
)