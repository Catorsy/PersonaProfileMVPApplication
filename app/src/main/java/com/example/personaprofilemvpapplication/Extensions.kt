package com.example.personaprofilemvpapplication

import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random

const val MAX_RAND = 2

fun makeSnackbar(text: String, binding: ViewBinding) {
    Snackbar.make(binding.root, text, Snackbar.LENGTH_SHORT).show()
}

fun getRandom(): Int {
    return Random.nextInt(MAX_RAND)
}