package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "concerts")
data class Concert(
    @PrimaryKey val id: Int,
    val singerId: Int,
    val club: String,
    val city: String,
    )