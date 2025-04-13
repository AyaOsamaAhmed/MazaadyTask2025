package com.aya.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Movies")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String? = null,
    val posterPath: String?,
    val overview: String?,
    val releaseDate: String? = null,
    val isFavorite: Boolean = false
)
