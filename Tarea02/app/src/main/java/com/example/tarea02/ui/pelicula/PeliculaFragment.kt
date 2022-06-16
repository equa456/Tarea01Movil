package com.example.tarea02.ui.pelicula

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea02.R
import com.example.tarea02.adapter.PeliculaAdapter
import com.example.tarea02.databinding.FragmentPeliculaBinding
import com.example.tarea02.viewmodel.PeliculaViewModel

class PeliculaFragment : Fragment() {

    private lateinit var  peliculaViewModel: PeliculaFragment

    private var _binding: FragmentPeliculaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        peliculaViewModel = ViewModelProvider(this)[PeliculaFragment::class.java]
        _binding= FragmentPeliculaBinding.inflate(inflater,container,false)

        //Se programa la accion para pasarse a AddLugar
        binding.addLugarButton.setOnClickListener {
            findNavController().navigate(R.id.action_nav_pelicula_to_addPeliculaFragment)
        }

        //Activar el reciclador -RecyclerView
        val lugarAdapter = PeliculaAdapter()
        val reciclador = binding.reciclador

        reciclador.adapter = lugarAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())
        peliculaViewModel = ViewModelProvider(this)[PeliculaViewModel::class.java]

        peliculaViewModel.getAllData.observe(viewLifecycleOwner){
            peliculas -> lugarAdapter.setData(peliculas)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}