package com.example.mealoftheday.rest

import com.example.mealoftheday.model.randomMeal.Meal

sealed class UIState {

    class LOADING(val isLoading: Boolean = true) : UIState()
    class SUCCESS(val meal: Meal) : UIState()
    class ERROR(val error: Throwable): UIState()
}
