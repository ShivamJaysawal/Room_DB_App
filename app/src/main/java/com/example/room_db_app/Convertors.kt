package com.example.room_db_app

import androidx.room.TypeConverter
import java.util.Date

class Convertors {

    @TypeConverter
    fun fromDateToLong(date :Date):Long{
        return date.time
    }

    @TypeConverter
    fun fromLongToDate(value :Long):Date{
        return Date(value)
    }

}