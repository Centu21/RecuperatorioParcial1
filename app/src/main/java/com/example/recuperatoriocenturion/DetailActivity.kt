package com.example.recuperatoriocenturion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private lateinit var IngredientesDetalle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val receta = intent.getParcelableExtra<Receta>("receta")

        IngredientesDetalle = findViewById(R.id.tvIngredientesDetalle)
        IngredientesDetalle.text = receta?.ingredientes.toString()


    }
}