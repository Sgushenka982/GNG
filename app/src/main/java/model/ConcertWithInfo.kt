package model

import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Relation

@DatabaseView
data class ConcertWithInfo(
    @Embedded val concert: Concert,
    @Relation(
        parentColumn = "id",
        entityColumn = "concertId"
    )
    val riderList: List<Rider>,
    @Relation(
        parentColumn = "id",
        entityColumn = "concertId"
    )
    val codeList: List<Code>,
    @Relation(
        parentColumn = "id",
        entityColumn = "concertId"
    )
    val guestList: List<Guest>,
) {
}