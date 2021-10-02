package com.example.personaprofilemvpapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.personaprofilemvpapplication.R
import com.example.personaprofilemvpapplication.databinding.ActivityEditPersonaProfileBinding
import com.example.personaprofilemvpapplication.makeSnackbar
import com.example.personaprofilemvpapplication.model.Persona

class EditPersonaProfileActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityEditPersonaProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPersonaProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with (binding) {
        rememberPasswordButton.setOnClickListener {
            makeSnackbar(getString(R.string.you_need_register_again), binding)
        }
        enterButton.setOnClickListener {
            makeSnackbar(getString(R.string.you_cannt_enter_just_now), binding)
            //setCountryError(getRandom())
        }
        registerButton.setOnClickListener {
            //тут надо вызывать презентер. Но его пока нет!
        }
    }

    override fun setState(state: Contract.ViewState) {
        setDefaultVisibilities()
        setNewState(state)
    }

    private fun setNewState(state: Contract.ViewState) {
        when (state) {
            Contract.ViewState.IDLE -> {
                binding.contentLayout.isVisible = true
            }
            Contract.ViewState.LOADING -> {
                binding.progressBar.isVisible = true
            }
            Contract.ViewState.SUCCESS -> {
                binding.successImageView.isVisible = true
            }
            Contract.ViewState.ERROR -> {
                setError()
            }
        }
    }

    private fun setDefaultVisibilities() = with(binding) {
        contentLayout.isVisible = false
        progressBar.isVisible = false
        successImageView.isVisible = false
    }

    private fun setError() {
        binding.contentLayout.isVisible = true
        makeSnackbar(getString(R.string.no_success), binding)
    }

    override fun setPersona(persona: Persona) = with (binding){
        nicknameEditText.setText(persona.nickname)
        ageEditText.setText(persona.age)
        countryEditText.setText(persona.country.name)
        passwordEditText.setText(persona.password)
    }

    override fun setCountryError(errorCode: Int) {
        binding.countryEditText.error = getErrorStringByCode(errorCode)
    }

    private fun getErrorStringByCode(errorCode: Int): String {
        when (errorCode) {
            0 -> return getString(R.string.this_country_do_not_exist)
        }
        return getString(R.string.no_connection_with_base)
    }

    override fun setPasswordError(persona: Persona) {
        if (persona.password.isEmpty()) {
            binding.passwordEditText.error = getString(R.string.field_cannot_be_empty)
        }
        if(persona.password.isBlank()){
            binding.passwordEditText.error = getString(R.string.password_cannot_be_blank)
        }
    }
}