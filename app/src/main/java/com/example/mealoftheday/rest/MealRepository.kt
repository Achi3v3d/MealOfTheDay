package com.example.mealoftheday.rest

import com.example.mealoftheday.model.randomMeal.Meal
import retrofit2.Response

interface MealRepository{
    fun getMealOfTheDay() : Response<Meal>
}
class MealRepositoryImpl(
    val networkApi: NetworkApi
):MealRepository{

    override fun getMealOfTheDay(): Response<Meal> {

     networkApi.getMeals()

    }

}