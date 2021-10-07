package com.example.personaprofilemvpapplication.impl

import android.app.Activity
import android.content.Context
import android.content.Intent

import com.example.personaprofilemvpapplication.model.Persona
import com.example.personaprofilemvpapplication.ui.MainActivity
import com.example.personaprofilemvpapplication.ui.Router

class RouterImpl() : Router {
    override fun openMainScreen(activity: Activity, persona: Persona?) {
//        val intent = Intent(activity, MainActivity::class.java)
//        intent.putExtra(MainActivity.PERSONA_EXTRA_KEY, persona)

        //activity.startActivity(intent)

        activity.startActivity(MainActivity.createLaunchIntent(activity, persona))
    }

    override fun openMainScreen(activity: Activity) {
        openMainScreen(activity, null)
    }
}
