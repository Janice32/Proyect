package cl.desafiolatam.proyect.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Drink (

    @SerializedName("codigo") val codigo : String,
    @SerializedName("nombre") val nombre : String,
    @SerializedName("unidad_medida") val unidad_medida : String,
    @SerializedName("fecha") val fecha : String,
    @SerializedName("valor") val valor : Double
)
/*  antes es sin data y entre {}
@SerializedName("Id")
@Expose
var id: Int? = null
@SerializedName("nombre")
@Expose
var title: String? = null
@SerializedName("url")
@Expose
var url: String? = null
@SerializedName("imagen")
@Expose
var thumbnail: String? = null*/