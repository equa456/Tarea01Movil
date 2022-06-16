package com.example.tarea02.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "pelicula")
data class Pelicula (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "estudio")
    val estudio: String?,
    @ColumnInfo(name = "annio")
    val annio: String?
) : Parcelable