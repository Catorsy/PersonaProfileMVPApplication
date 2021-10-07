package com.example.personaprofilemvpapplication

import android.app.Application
import com.example.personaprofilemvpapplication.impl.RouterImpl
import com.example.personaprofilemvpapplication.ui.Router

class App : Application() {
   val router: Router = RouterImpl()
}
