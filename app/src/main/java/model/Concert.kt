package model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "concerts")
data class Concert(
    @PrimaryKey val id: Int,
    @NonNull
    val singerId: Int,
    @NonNull
    val club: String,
    @NonNull
    val city: String
    )