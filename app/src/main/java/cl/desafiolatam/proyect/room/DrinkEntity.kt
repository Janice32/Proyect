package cl.desafiolatam.proyect.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "drink_list")

data class DrinkEntity (@ColumnInfo(name = "codigo")// va id
                           @PrimaryKey(autoGenerate = true)

                        @SerializedName("codigo") val codigo : String,
                        @SerializedName("nombre") val nombre : String,
                        @SerializedName("unidad_medida") val unidad_medida : String,
                        @SerializedName("fecha") val fecha : String,
                        @SerializedName("valor") val valor : Double
)

/*
                        @SerializedName("id")   val id : Int,
                        @SerializedName("nombre")  val title : String,
                        @SerializedName("precio")  val url : String?,
                        @SerializedName("imagen")  val thumbnail : String)*/



