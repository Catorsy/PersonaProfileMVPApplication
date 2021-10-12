package com.example.personaprofilemvpapplication.model

import java.io.Serializable

data class Country(
    val name: String,
    val language: String? = null,
): Serializable
