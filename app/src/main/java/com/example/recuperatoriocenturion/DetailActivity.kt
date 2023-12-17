package com.example.recuperatoriocenturion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var IngredientesDetalle: TextView
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        IngredientesDetalle = findViewById(R.id.tvIngredientesDetalle)
        IngredientesDetalle.text = receta?.ingredientes.toString()


        btnVolver = findViewById(R.id.btnVolverPP)
        btnVolver.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}