package com.example.dimare.data.helpers

import androidx.room.TypeConverter
import com.example.dimare.data.entities.Pizza
import com.google.gson.Gson
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun fromTimestamp(date: String): LocalDateTime = LocalDateTime.parse(date)

    @TypeConverter
    fun dateToTimestamp(date: LocalDateTime): String = date.toString()

    @TypeConverter
    fun fromJson(json: String): MutableMap<*, *> = Gson().fromJson(json, MutableMap::class.java)

    @TypeConverter
    fun toJson(map: MutableMap<Pizza, Int>): String = Gson().toJson(map)
}
