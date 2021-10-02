package com.example.personaprofilemvpapplication.ui

import com.example.personaprofilemvpapplication.model.Persona

class Contract {
    enum class ViewState{
        IDLE, LOADING, SUCCESS, ERROR
    }

    interface View {
        fun setState(state: ViewState)
        fun setPersona(persona: Persona)
        fun setCountryError(errorCode: Int)
        fun setPasswordError(persona: Persona)
    }

    interface Presenter {
        fun onAttach(view: View)
        fun onDetach()
        fun onRegister(persona: Persona)
        fun onEnterInAccount(nickname: String, password: String)
        fun onRememberMyPassword(nickname: String)
        fun onCheckCountry(country: String) //идем на сервер, проверяем список доступных стран
    }
}