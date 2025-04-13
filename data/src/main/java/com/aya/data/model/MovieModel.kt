package com.aya.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieModel(
    val id: Int? = null,
    val title: String? = null,
    val year: Long? = null,
    val genre: List<String>? = null,
    val rating: Double? = null,
    val director: String? = null,
    val actors: List<String>? = null,
    val plot: String? = null,
    val poster: String? = null,
    val trailer: String? = null,
    val runtime: Long? = null,
    val awards: String? = null,
    val country: String? = null,
    val language: String? = null,
    val boxOffice: String? = null,
    val production: String? = null,
    val website: String? = null
) : Parcelable