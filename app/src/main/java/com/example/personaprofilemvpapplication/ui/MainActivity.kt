package com.example.personaprofilemvpapplication.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.personaprofilemvpapplication.databinding.ActivityMainBinding
import com.example.personaprofilemvpapplication.model.Persona

class MainActivity: AppCompatActivity() {
    companion object{
        private val PERSONA_EXTRA_KEY = "key"
        fun createLaunchIntent(context: Context, persona: Persona?) : Intent {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra(PERSONA_EXTRA_KEY, persona)
            return intent
        }

        fun createLaunchIntent(context: Context) : Intent {
            return createLaunchIntent(context, null)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}