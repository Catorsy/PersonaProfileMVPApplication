package com.example.personaprofilemvpapplication.model

data class Persona(
    val nickname: String,
    val age: Int,
    val country: Country,
    val password: String,
    val id: Int? = null,
)