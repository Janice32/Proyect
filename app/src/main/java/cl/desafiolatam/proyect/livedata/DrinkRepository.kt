package cl.desafiolatam.proyect.livedata

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import cl.desafiolatam.proyect.retrofit.DrinkRetrofitClient.Companion.retrofitInstance
import cl.desafiolatam.proyect.room.DrinkDAO
import cl.desafiolatam.proyect.room.DrinkDatabase
import cl.desafiolatam.proyect.room.DrinkEntity
import cl.desafiolatam.proyect.room.RoomApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await

class DrinkRepository (private val database: DrinkDatabase) {

    private val drinkDAO : DrinkDAO = RoomApplication.drinkdatabase!!.getDrinkDao()

    val allMakeupItem:LiveData<List<DrinkEntity>> = drinkDAO.getAllDrink()




    suspend fun refreshDrink(){
        withContext(Dispatchers.IO){
            val characterList = retrofitInstance().getAllDrink().await()
            database.getDrinkDao().insertAll(characterList)
        }
    }



}