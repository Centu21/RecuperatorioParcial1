package com.example.recuperatoriocenturion

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data  class Receta (
     val id: Int,
     val plato: Plato,
     val dificultad: Dificultad,
     val origen: Origen,
     val ingredientes: Ingredientes
): Parcelable

enum class Plato {
    Albondigas_Con_Pure,
    Filet_con_Papas,
    Milanesa_Napolitana,
    Pastel_de_Papa,
    Pollo_con_Papas,
    Ravioles_Fileto
}


enum class Dificultad {
    FACIL,
    MEDIANA,
    DIFICIL
}

enum class Origen {
    ARGENTINA,
    ESPAÑA,
    ITALIA,
    INGLATERRA
}

enum class Ingredientes {
    POLLO_PAPAS,
    CARNE_PICADA_AJO_PEREGIL_PAPAS,
    MILANESAS_JAMON_QUESO_SALSA_TOMATE_PAPAS,
    MERLUZA_HARINA_PAPAS,
    RAVIOLES_SALSA,
    CARNE_PICADA_AJO_PAPA_HUEVO_MORRON

}
