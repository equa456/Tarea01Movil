package com.example.tarea02.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea02.model.Pelicula

@Database(entities = [Pelicula::class], version = 1, exportSchema = false)
abstract class PeliculaDatabase : RoomDatabase(){
    abstract fun peliculaDao() : PeliculaDao

    companion object{

        @Volatile
        private var INSTANCE: PeliculaDatabase? = null

        fun getDatabase(context: android.content.Context) : PeliculaDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PeliculaDatabase::class.java,
                    "pelicula_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}