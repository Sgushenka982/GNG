package repository

import androidx.room.Dao
import androidx.room.Query
import model.Code
import model.Concert
import model.ConcertWithInfo
import model.Guest
import model.Rider

@Dao
interface ConcertRepository {
    @Query("SELECT * FROM concerts")
    fun getAll(): List<Concert>

    @Query("SELECT * FROM concerts")
    fun getAllConcerts(): List<ConcertWithInfo>

    @Query("Select * From rider where concertId = :concertId")
    fun getAllRiders(concertId: Int): List<Rider>

    @Query("Select * From guests where concertId = :concertId")
    fun getAllGuest(concertId: Int): List<Guest>

    @Query("Select * From codes where concertId = :concertId")
    fun getAllCodes(concertId: Int): List<Code>
}