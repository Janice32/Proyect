package cl.desafiolatam.proyect.retrofit

import cl.desafiolatam.proyect.pojo.Drink
import cl.desafiolatam.proyect.room.DrinkEntity
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("https://mindicador.cl/api")//https://sourlife.ecmdevelop.cl/
    fun getAllDrink(): Call<ArrayList<DrinkEntity>>
}