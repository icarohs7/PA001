package io.icarotemponi.pa001.shared.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class PATimeInterval(
    @PrimaryKey val id: Int,
    val start: Date,
    val end: Date
)
