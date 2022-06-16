package com.example.tarea02.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarea02.model.Pelicula

@Dao
interface PeliculaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPelicula(pelicula: Pelicula)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updatePelicula(pelicula: Pelicula)

    @Delete
    suspend fun deletePelicula(pelicula: Pelicula)

    @Query("SELECT * FROM PELICULA")
    fun getAllData(): LiveData<List<Pelicula>>
}