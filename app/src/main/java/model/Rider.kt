package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rider")
data class Rider(
    @PrimaryKey val id: Int,
    val requirements: String,
    val concertId: Int
    )