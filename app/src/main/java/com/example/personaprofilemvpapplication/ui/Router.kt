package com.example.personaprofilemvpapplication.ui

import android.app.Activity
import com.example.personaprofilemvpapplication.model.Persona

interface Router {
    fun openMainScreen(activity: Activity, persona: Persona?)
    fun openMainScreen(activity: Activity)
}
