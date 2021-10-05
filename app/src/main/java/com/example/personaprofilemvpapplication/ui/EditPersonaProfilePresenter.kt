package com.example.personaprofilemvpapplication.ui

import com.example.personaprofilemvpapplication.*
import com.example.personaprofilemvpapplication.model.Persona

class EditPersonaProfilePresenter : Contract.Presenter {
    private var view: Contract.View? = null
    private var persona: Persona? = null

    override fun onAttach(view: Contract.View) {
        this.view = view
        view.setState(Contract.ViewState.IDLE)
        persona?.let{
            view.setPersona(it)
        }
    }

    override fun onDetach() {
        view = null
    }

    override fun onRegister(persona: Persona) {
        //можно было бы сымитировать задержку с хендлером, но это андроид-класс, не положен презентеру
        view?.setState(Contract.ViewState.ERROR)
    }

    override fun onEnterInAccount(nickname: String, password: String) {
    }

    override fun onRememberMyPassword(nickname: String) {
    }

    override fun onCheckCountry(country: String) {
        view?.setCountryError(getRandom())
    }

    override fun onCheckMyPassword(password: String) {
        if (password.isBlank()) {
            view?.setPasswordError(BLANK_ERROR)
        }
        if (password.isEmpty()) {
            view?.setPasswordError(EMPTY_ERROR)
        }
    }
}