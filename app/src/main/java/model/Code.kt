package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "codes")
data class Code(
    @PrimaryKey val id:Int,
    @NotNull
    val concertId: Int,
    @NotNull
    val code: String
)