package com.example.personaprofilemvpapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.example.personaprofilemvpapplication.*
import com.example.personaprofilemvpapplication.databinding.ActivityEditPersonaProfileBinding
import com.example.personaprofilemvpapplication.model.Country
import com.example.personaprofilemvpapplication.model.Persona
import java.lang.NumberFormatException

class EditPersonaProfileActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityEditPersonaProfileBinding
    private var presenter: Contract.Presenter = EditPersonaProfilePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPersonaProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter.onAttach(this)
        initView()
    }

    private fun initView() {
        initButtons()
        checkFields()
    }

    private fun checkFields() = with(binding) {
        countryEditText.addTextChangedListener {
            presenter.onCheckCountry(it.toString())
        }
        passwordEditText.addTextChangedListener {
            presenter.onCheckMyPassword(it.toString())
        }
    }

    private fun initButtons() = with(binding) {
        rememberPasswordButton.setOnClickListener {
            makeSnackbar(getString(R.string.you_need_register_again), binding)
            //вообще тут тоже положено писать реализацию через презентер, но т.к. у меня здесь не проверка,
            //а ТОЛЬКО сообщение, позвольте мне оставить это так.
            //иначе было бы что-то вроде presenter.onRememberMyPassword(NICKNAME, binding) - с передачей
            //вьюБиндинг ради того, чтобы отобразить снекбар...
            presenter.onRememberMyPassword(NICKNAME) //ничего не делает, но когда-нибудь может начать
        }
        enterButton.setOnClickListener {
            presenter.onEnterInAccount(NICKNAME, PASSWORD)
            makeSnackbar(getString(R.string.you_cannt_enter_just_now), binding)
        }
        registerButton.setOnClickListener {
            try {
                presenter.onRegister(gatherPersona())
            } catch (e: NumberFormatException) {
                makeSnackbar(getString(R.string.mark_all_fields), binding)
            }
        }
    }

    private fun gatherPersona(): Persona {
        return Persona(
            binding.nicknameEditText.text.toString(),
            binding.ageEditText.text.toString().toInt(),
            Country(binding.countryEditText.text.toString()),
            binding.passwordEditText.text.toString(),
        )
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

    override fun setPersona(persona: Persona) = with(binding) {
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
            INCORRECT_COUNTRY_ERROR -> return getString(R.string.this_country_do_not_exist)
        }
        return getString(R.string.no_connection_with_base)
    }

    override fun setPasswordError(errorCode: Int) {
        when (errorCode) {
            EMPTY_ERROR -> binding.passwordEditText.error =
                getString(R.string.field_cannot_be_empty)
            BLANK_ERROR -> binding.passwordEditText.error =
                getString(R.string.password_cannot_be_blank)
        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}