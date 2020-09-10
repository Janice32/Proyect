package cl.desafiolatam.proyect.room

import android.app.Application
import androidx.room.Room


class RoomApplication : Application() {
    companion object {
        var drinkdatabase: DrinkDatabase? = null

    }

    override fun onCreate() {
        super.onCreate()
        drinkdatabase = Room.databaseBuilder(this,DrinkDatabase::class.java,"drink_list"). fallbackToDestructiveMigration().build()
    }
}
