package com.example.personaprofilemvpapplication

import com.example.personaprofilemvpapplication.model.Persona
import com.example.personaprofilemvpapplication.ui.MainActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen

object Screens {
    fun Main(persona: Persona?) = ActivityScreen { MainActivity.createLaunchIntent(it, persona) }
    //контекст передали
}