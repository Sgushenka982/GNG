package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "singers")
data class Singer(
    @PrimaryKey val id: Int,
    val name: String,
)