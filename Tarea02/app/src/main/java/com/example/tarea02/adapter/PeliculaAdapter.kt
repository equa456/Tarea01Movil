package com.example.tarea02.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea02.databinding.PeliculaFilaBinding
import com.example.tarea02.model.Pelicula
import com.lugares.databinding.LugarFilaBinding
import com.lugares.model.Lugar
import com.lugares.ui.lugar.LugarFragmentDirections

class PeliculaAdapter : RecyclerView.Adapter<PeliculaAdapter.LugarViewHolder>() {

    //una lista para almacenar la informacionnde los lugares
    private var listaLugares = emptyList<Pelicula>()

    inner class LugarViewHolder(private val itemBinding: PeliculaFilaBinding):
        RecyclerView.ViewHolder(itemBinding.root){
            fun dibuja(pelicula: Pelicula){
                itemBinding.tvNombre.text = pelicula.nombre
                itemBinding.tvEstudio.text = pelicula.estudio
                itemBinding.tvAnnio.text = pelicula.annio
                itemBinding.vistaFila.setOnClickListener{
                    val accion = PeliculaFragmentDirections
                        .actionNavLugarToUpdateLugarFragment(pelicula)
                    itemView.findNavController().navigate(accion)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LugarViewHolder {
        val itemBinding =
            PeliculaFilaBinding.inflate(
                LayoutInflater.from(parent.context),parent,false)
        return LugarViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: LugarViewHolder, position: Int) {
        val lugar = listaLugares[position]
        holder.dibuja(lugar)
    }

    override fun getItemCount(): Int {
        return listaLugares.size
    }

    fun setData(lugares: List<Pelicula>){
        this.listaLugares=lugares

        //La siguiente instruccion redibuja toda la pantalla
        notifyDataSetChanged()
    }
}