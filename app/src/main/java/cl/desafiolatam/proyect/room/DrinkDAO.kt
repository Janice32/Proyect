package cl.desafiolatam.proyect.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DrinkDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDrinkItem(drinkEntity: DrinkEntity)

    @Insert
    fun updateDrinkItem(drinkEntity: DrinkEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(drink: List<DrinkEntity>)

    @Delete
    fun clearAllDrinkItem(vararg creature: DrinkEntity)

    @Query("SELECT * FROM drink_list")
    fun getAllDrink(): LiveData<List<DrinkEntity>>
}