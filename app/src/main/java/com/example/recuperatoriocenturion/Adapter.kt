package com.example.recuperatoriocenturion


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView



class Adapter (val context: Context): ListAdapter<Receta, Adapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Receta) -> Unit

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private val plato: TextView = view.findViewById(R.id.tvReceta)
        private val dificultad: TextView = view.findViewById(R.id.tvDificultad)
        private val origen: TextView = view.findViewById(R.id.tvOrigen)
        private val imagenRecetas: ImageView = view.findViewById(R.id.imagenReceta)

        fun bind (receta: Receta){

            plato.text = receta.plato.toString()
            dificultad.text = receta.dificultad.toString()
            origen.text = receta.dificultad.toString()


            val imagen = when (receta.plato) {
                Plato.Albondigas_Con_Pure -> R.drawable.albondigas
                Plato.Filet_con_Papas -> R.drawable.filet
                Plato.Milanesa_Napolitana -> R.drawable.milanesa
                Plato.Pastel_de_Papa -> R.drawable.pastel
                Plato.Pollo_con_Papas -> R.drawable.pollo
                else -> {R.drawable.ravioles}
            }
            imagenRecetas.setImageResource(imagen)

            view.setOnClickListener{
                onItemClickListener(receta)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder{
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int){
        val receta = getItem(position)
        holder.bind(receta)

    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {

            return oldItem.id ==newItem.id

        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {

            return oldItem == newItem
        }
    }

}