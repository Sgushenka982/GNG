package model

import androidx.room.Embedded
import androidx.room.Relation


data class SingerWithConcert (
    @Embedded val singer: Singer,
    @Relation(
        entity = Concert::class,
        parentColumn = "id",
        entityColumn = "singerId"
    )
    val concertList: List<ConcertWithInfo>
)