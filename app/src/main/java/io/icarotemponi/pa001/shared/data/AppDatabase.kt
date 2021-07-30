package io.icarotemponi.pa001.shared.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.icarotemponi.pa001.shared.models.PATimeInterval

@TypeConverters(value = [RoomTypeConverters::class])
@Database(entities = [PATimeInterval::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun paTimeIntervalDao(): PATimeIntervalDao
}