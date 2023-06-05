package room

import androidx.room.Database
import androidx.room.RoomDatabase
import model.Concert
import model.Rider
import model.Singer
import repository.ConcertRepository
import repository.SingerRepository

@Database(entities = [Singer::class, Concert::class, Rider::class], version = 3)
abstract class AppDatabase: RoomDatabase() {
    abstract fun singerRepository(): SingerRepository
    abstract fun concertRepository(): ConcertRepository
}