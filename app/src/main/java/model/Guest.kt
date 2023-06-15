package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "guests")
data class Guest(
    @PrimaryKey val id: Int,
    @NotNull
    val concertId: Int,
    @NotNull
    val type: Int,
    @NotNull
    val guest: String
)