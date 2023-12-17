package com.example.recuperatoriocenturion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvRecetas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter(this)
        recyclerView.adapter = adapter
        adapter.submitList(getListadoRecetas())

        adapter.onItemClickListener = {
        navegarDetalle(it)
        }

    }

    private fun navegarDetalle(receta: Receta) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("receta", receta)
        startActivity(intent)

    }

    private fun getListadoRecetas(): MutableList<Receta>? {
        return mutableListOf(
            Receta(1,Plato.Albondigas_Con_Pure,Dificultad.FACIL,Origen.ESPAÑA,Ingredientes.CARNE_PICADA_AJO_PEREGIL_PAPAS),
            Receta(2,Plato.Filet_con_Papas,Dificultad.MEDIANA,Origen.ITALIA,Ingredientes.MERLUZA_HARINA_PAPAS),
            Receta(3,Plato.Milanesa_Napolitana,Dificultad.MEDIANA,Origen.ARGENTINA,Ingredientes.MILANESAS_JAMON_QUESO_SALSA_TOMATE_PAPAS),
            Receta(4,Plato.Pastel_de_Papa,Dificultad.DIFICIL,Origen.INGLATERRA,Ingredientes.CARNE_PICADA_AJO_PAPA_HUEVO_MORRON),
            Receta(5,Plato.Pollo_con_Papas,Dificultad.FACIL,Origen.ARGENTINA,Ingredientes.POLLO_PAPAS),
            Receta(6,Plato.Ravioles_Fileto,Dificultad.FACIL,Origen.ITALIA,Ingredientes.RAVIOLES_SALSA)
        )


    }
}