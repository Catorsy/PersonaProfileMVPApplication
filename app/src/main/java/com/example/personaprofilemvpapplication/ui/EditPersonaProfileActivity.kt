package com.example.personaprofilemvpapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.personaprofilemvpapplication.R
import com.example.personaprofilemvpapplication.model.Persona

class EditPersonaProfileActivity : AppCompatActivity(), Contract.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_persona_profile)
    }

    override fun setState(state: Contract.ViewState) {
        TODO("Not yet implemented")
    }

    override fun setPersona(persona: Persona) {
        TODO("Not yet implemented")
    }

    override fun setCountryError(errorCode: Int) {
        TODO("Not yet implemented")
    }

    override fun setPasswordError(errorCode: Int) {
        TODO("Not yet implemented")
    }
}