package repository

import androidx.room.Dao
import androidx.room.Query
import model.Concert

@Dao
interface ConcertRepository {
    @Query("SELECT * FROM concerts")
    fun getAll(): List<Concert>
}