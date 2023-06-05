package repository

import androidx.room.Dao
import androidx.room.Query
import model.Concert
import model.Rider

@Dao
interface ConcertRepository {
    @Query("SELECT * FROM concerts")
    fun getAll(): List<Concert>

    @Query("Select * From rider where concertId = :concertId")
    fun getAllRiders(concertId: Int): List<Rider>
}