package cl.desafiolatam.proyect.livedata

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.desafiolatam.proyect.room.DrinkDatabase.Companion.getDatabase
import cl.desafiolatam.proyect.room.DrinkEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException

class DrinkViewModel (application: Application): AndroidViewModel(application) {

    private val repository = DrinkRepository(getDatabase(application))
    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope ( viewModelJob + Dispatchers.Main )
    val drinkCharacters = repository.allMakeupItem
    val AllDrinkItem: LiveData<List<DrinkEntity>>

    init {

        AllDrinkItem = drinkCharacters
        refreshDataFromRepository()

    }
    private fun refreshDataFromRepository(){
        viewModelScope.launch {
            try {
                repository.refreshDrink()
            }catch (networkError: IOException){
                Log.e("ViewModel", "Cannon refresh data from repository", networkError)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
    class Factory(val app: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DrinkViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return DrinkViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }

    }
}