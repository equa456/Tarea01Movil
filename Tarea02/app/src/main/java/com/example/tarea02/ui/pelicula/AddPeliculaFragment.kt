package com.example.tarea02.ui.pelicula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tarea02.R
import com.example.tarea02.databinding.FragmentAddPeliculaBinding
import com.example.tarea02.model.Pelicula
import com.example.tarea02.viewmodel.PeliculaViewModel
import com.lugares.R
import com.lugares.databinding.FragmentAddLugarBinding
import com.lugares.model.Lugar
import com.lugares.viewmodel.LugarViewModel


class AddPeliculaFragment : Fragment() {

    private lateinit var  peliculaViewModel: PeliculaViewModel

    private var _binding: FragmentAddPeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        peliculaViewModel = ViewModelProvider(this)[PeliculaViewModel::class.java]
        _binding= FragmentAddPeliculaBinding.inflate(inflater,container,false)

        //Se agrega la funcion para agregar un lugar
       binding.btActualizar.setOnClickListener{ addLugar()}


        return binding.root
    }

    private fun addLugar() {
        val  nombre=binding.etNombre.text.toString()
        val  correo=binding.etEstudio.text.toString()
        val  telefono=binding.etAnnio.text.toString()
        if(nombre.isNotEmpty()){
            val pelicula = Pelicula(0,nombre,correo,telefono)
            peliculaViewModel.addPelicula(pelicula)
            Toast.makeText(requireContext(),getString(R.string.peliculaAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updatePeliculaFragment_to_nav_pelicula)
        } else{
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}