package com.example.mealoftheday.rest

import com.example.mealoftheday.model.randomMeal.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

interface MealRepository{
    val mealResponse: StateFlow<UIState>
    suspend fun getMealOfTheDay()


}
class MealRepositoryImpl(
    val networkApi: NetworkApi
):MealRepository{

    private var _mealResponse: MutableStateFlow<UIState> = MutableStateFlow(UIState.LOADING())
    override val mealResponse: StateFlow<UIState>
        get() = _mealResponse

    override suspend fun getMealOfTheDay() {
try {
    val response = networkApi.getMeals()
    if(response.isSuccessful){
        response.body()?.let { body ->
            _mealResponse.value = UIState.SUCCESS(body)
        } ?: UIState.ERROR(Throwable("Response is null"))


    }else{
        UIState.ERROR(Throwable(response.errorBody()?.string()))
    }
    }catch (e:Exception){
        UIState.ERROR(e)
    }

    }

}