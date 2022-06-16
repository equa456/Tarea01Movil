package com.example.tarea02.ui.pelicula

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.tarea02.R
import com.example.tarea02.databinding.FragmentAddLugarBinding
import com.example.tarea02.databinding.FragmentUpdatePeliculaBinding
import com.example.tarea02.ex.Lugar
import com.example.tarea02.viewmodel.PeliculaViewModel


class UpdatePeliculaFragment : Fragment() {

    //Defino un argumento
    private  val args by navArgs<UpdatePeliculaFragmentArgs>()

    private lateinit var  lugarViewModel: PeliculaViewModel

    private var _binding: FragmentUpdatePeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this)[LugarViewModel::class.java]
        _binding= FragmentUpdateLugarBinding.inflate(inflater,container,false)

        //Se coloca la info del objeto lugar que me pasaron
        binding.etNombre.setText(args.lugar.nombre)
        binding.etTelefono.setText(args.lugar.telefono)
        binding.etCorreo.setText(args.lugar.correo)
        binding.etWeb.setText(args.lugar.web)

        //Se agrega la funcion para actualizar un lugar
       binding.btActualizar.setOnClickListener{ updateLugar()}


        return binding.root
    }


    private fun updatePelicula() {
        val  nombre=binding.etNombre.text.toString()
        val  correo=binding.etCorreo.text.toString()
        val  telefono=binding.etTelefono.text.toString()
        val  web=binding.etWeb.text.toString()
        if(nombre.isNotEmpty()){
            val lugar = Lugar(args.lugar.id,nombre,correo,telefono,web,0.0,0.0,0.0,"","")
            lugarViewModel.updateLugar(lugar)
            Toast.makeText(requireContext(),getString(R.string.lugarAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)
        } else{
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}