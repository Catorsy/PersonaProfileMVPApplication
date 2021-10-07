package com.example.personaprofilemvpapplication.ui

import com.example.personaprofilemvpapplication.*
import com.example.personaprofilemvpapplication.model.Persona
import com.github.terrakok.cicerone.Router

class EditPersonaProfilePresenter(private val router: Router) : Contract.Presenter() {
    private var persona: Persona? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setState(Contract.ViewState.IDLE)
    }

    override fun onRegister(persona: Persona) {
        //можно было бы сымитировать задержку с хендлером, но это андроид-класс, не положен презентеру
        //viewState.setState(Contract.ViewState.ERROR)
        viewState.setState(Contract.ViewState.SUCCESS)
//        viewState.openMainScreen(persona)
//        viewState.exit()
        router.exit()
        router.navigateTo(Screens.Main(persona))
    }

    override fun onEnterInAccount(nickname: String, password: String) {
    }

    override fun onRememberMyPassword(nickname: String) {
    }

    override fun onCheckCountry(country: String) {
        viewState.setCountryError(getRandom())
    }

    override fun onCheckMyPassword(password: String) {
        if (password.isBlank()) {
            viewState.setPasswordError(BLANK_ERROR)
        }
        if (password.isEmpty()) {
            viewState.setPasswordError(EMPTY_ERROR)
        }
    }
}