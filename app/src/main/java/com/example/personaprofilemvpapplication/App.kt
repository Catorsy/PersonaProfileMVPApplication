package com.example.personaprofilemvpapplication

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class App : Application() {
   private val cicerone = Cicerone.create()
   val router get() = cicerone.router
   val navigatorHolder get() = cicerone.getNavigatorHolder() //это чтобы с фрагментами работать можно было

//   override fun onCreate() { //можно пользоваться тем, что мы написали
//      super.onCreate()
//      INSTANCE = this
//   }
//
//   companion object {
//      internal lateinit var INSTANCE: App
//         private set
//   }
}