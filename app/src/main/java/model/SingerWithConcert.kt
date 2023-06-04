package model

import androidx.room.Embedded
import androidx.room.Relation


data class SingerWithConcert (
    @Embedded val singer: Singer,
    @Relation(
        parentColumn = "id",
        entityColumn = "singerId"
    )
    val concertList: List<Concert>
)