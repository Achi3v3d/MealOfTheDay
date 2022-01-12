package com.example.mealoftheday.rest

import com.example.mealoftheday.model.randomMeal.Meal
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {
@GET(MEAL_OF_DAY)
suspend fun getMeals(): Response<Meal>

companion object{
    const val BASE_URL = "www.themealdb.com/api/json/v1/1/"
    private const val MEAL_OF_DAY = "random.php"
}
}