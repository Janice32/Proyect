package cl.desafiolatam.proyect.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DrinkRetrofitClient {
    companion object{
        private const val BASE_URL = "https://mindicador.cl/api"//https://sourlife.ecmdevelop.cl/

        fun retrofitInstance():  Api {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(
                    GsonConverterFactory.create()).build()

            return  retrofit.create(Api::class.java)
        }
    }
}