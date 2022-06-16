package com.example.tarea02.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.tarea02.data.PeliculaDatabase
import com.example.tarea02.model.Pelicula
import com.example.tarea02.repository.PeliculaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeliculaViewModel(application: Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Pelicula>>

    //Esta es la manera como accedo al repositorio desde el viewModel
    private val repository: PeliculaRepository

    //Se procede a inicializar los atributos de arriba de esta clase LugarVieMopdel

    init {
        val peliculaDAo = PeliculaDatabase.getDatabase(application).peliculaDao()
        repository = PeliculaRepository(peliculaDAo)
        getAllData =  repository.getAllData
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para grabar un registro lugar
    fun addPelicula(pelicula: Pelicula){
        viewModelScope.launch(Dispatchers.IO){
            repository.addPelicula(pelicula)
        }
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para actualizar un registro lugar
    fun updatePelicula(pelicula: Pelicula){
        viewModelScope.launch(Dispatchers.IO){
            repository.updatePelicula(pelicula)
        }
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para eliminar un registro lugar
    fun deeletePelicula(pelicula: Pelicula){
        viewModelScope.launch(Dispatchers.IO){
            repository.deeletePelicula(pelicula)
        }
    }
}