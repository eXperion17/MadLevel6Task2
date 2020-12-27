package com.example.madlevel5task2.database

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromLong(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToLong(date: Date?): Long? {
        return date?.time?.toLong()
    }
}
