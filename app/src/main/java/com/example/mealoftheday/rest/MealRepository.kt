package com.example.mealoftheday.rest

import com.example.mealoftheday.model.randomMeal.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

interface MealRepository{
    fun getMealOfTheDay() : Response<Meal>
}
class MealRepositoryImpl(
    val networkApi: NetworkApi
):MealRepository{

    private var _mealResponse: MutableStateFlow<UIState> = MutableStateFlow(UIState.LOADING())






    val mealResponse: StateFlow<UIState> get() = _mealResponse
    override fun getMealOfTheDay(): Response<Meal> {

     networkApi.getMeals()

    }

}