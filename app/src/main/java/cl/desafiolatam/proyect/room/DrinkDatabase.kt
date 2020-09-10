package cl.desafiolatam.proyect.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(DrinkEntity:: class)], version = 2)

abstract class DrinkDatabase : RoomDatabase(){
    abstract fun getDrinkDao(): DrinkDAO
    companion object {
        @Volatile
        private var INSTANCE: DrinkDatabase? = null

        fun getDatabase(context: Context):DrinkDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,DrinkDatabase::class.java,"drink_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }


}