package com.example.tarea02.repository

import androidx.lifecycle.LiveData
import com.example.tarea02.data.PeliculaDao
import com.example.tarea02.model.Pelicula

class PeliculaRepository (private val peliculaDao: PeliculaDao) {
    //Se implementan las funciones de la interface

    //Se crea un objeto que contiene el arrayList de los registros de la tabla lugar... cubiertos por LiveData
    val getAllData: LiveData<List<Pelicula>> = peliculaDao.getAllData()

    //se define la funcion para insertar un l;ugar en la tabla
    suspend fun  addPelicula(pelicula: Pelicula){
        peliculaDao.addPelicula(pelicula)
    }

    //se define la funcion para actualizar un l;ugar en la tabla
    suspend fun updatePelicula(pelicula: Pelicula){
        peliculaDao.updatePelicula(pelicula)
    }

    //se define la funcion para eliminar un l;ugar en la tabla
    suspend fun deeletePelicula(pelicula: Pelicula){
        peliculaDao.deletePelicula(pelicula)
    }

}