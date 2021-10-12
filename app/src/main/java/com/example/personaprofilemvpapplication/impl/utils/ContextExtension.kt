package com.example.personaprofilemvpapplication.impl.utils

import android.content.Context
import com.example.personaprofilemvpapplication.App

val Context.app: App
    get() {
        return applicationContext as App
    }