package com.example.personaprofilemvpapplication

import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

const val MAX_RAND = 2
const val NICKNAME = "John"
const val PASSWORD = "1234AA"
const val EMPTY_ERROR = 0
const val BLANK_ERROR = 1
const val INCORRECT_COUNTRY_ERROR = 0

fun makeSnackbar(text: String, binding: ViewBinding) {
    Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
}

fun getRandom(): Int {
    return Random.nextInt(MAX_RAND)
}