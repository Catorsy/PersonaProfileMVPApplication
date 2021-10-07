package com.example.personaprofilemvpapplication.ui

import com.example.personaprofilemvpapplication.model.Persona
import moxy.MvpPresenter
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import moxy.viewstate.strategy.alias.Skip

class Contract {
    enum class ViewState {
        IDLE, LOADING, SUCCESS, ERROR
    }

    interface View: MvpView {
        @Skip
        fun setState(state: ViewState)
        @AddToEndSingle
        fun setPersona(persona: Persona)
        @AddToEndSingle
        fun setCountryError(errorCode: Int)
        @AddToEndSingle
        fun setPasswordError(errorCode: Int)

//        @Skip
//        fun exit()
//        @Skip
//        fun openMainScreen(persona: Persona?)
    }

    abstract class Presenter: MvpPresenter<View>() {
        abstract fun onRegister(persona: Persona)
        abstract fun onEnterInAccount(nickname: String, password: String)
        abstract fun onRememberMyPassword(nickname: String)
        abstract fun onCheckCountry(country: String)
        abstract fun onCheckMyPassword(password: String)
    }
}