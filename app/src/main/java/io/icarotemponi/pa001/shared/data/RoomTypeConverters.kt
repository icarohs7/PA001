package io.icarotemponi.pa001.shared.data

import androidx.room.TypeConverter
import java.util.*

class RoomTypeConverters {
    @TypeConverter
    fun fromDate(value: Date?): Long {
        return value?.time ?: -1
    }

    @TypeConverter
    fun toDate(value: Long): Date? {
        return if (value >= 0) Date(value) else null
    }
}