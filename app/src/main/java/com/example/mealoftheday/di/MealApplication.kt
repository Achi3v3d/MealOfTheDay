package com.example.mealoftheday.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class MealApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}