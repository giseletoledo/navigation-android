package com.ebac.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebac.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        supportActionBar?.title = " Jokenpô"

        val activity2Intent = Intent(this, MainActivityJogador::class.java)
        intent.putExtra("name", "Gisele")
        intent.putExtra("age", 39)

        binding.startActivityButton.setOnClickListener {
            startActivity(activity2Intent)
        }
    }
}