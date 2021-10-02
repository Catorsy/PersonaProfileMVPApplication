package com.example.personaprofilemvpapplication.model

//это модель

data class Persona(
    val nickname: String,
    val age: Int,
    val country: Country,
    val password: String,
    val id: Int? = null,
)