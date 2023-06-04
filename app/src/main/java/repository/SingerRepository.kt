package repository

import androidx.room.Dao
import androidx.room.Query
import model.Singer
import model.SingerWithConcert

@Dao
interface SingerRepository {
    @Query("SELECT * FROM singers")
    fun getAllSingers(): List<SingerWithConcert>

    @Query("SELECT * FROM singers")
    fun getAll(): List<Singer>
}