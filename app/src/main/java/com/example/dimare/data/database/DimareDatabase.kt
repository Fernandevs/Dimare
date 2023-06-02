package com.example.dimare.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

import com.example.dimare.data.dao.CommandDao
// import com.example.dimare.data.dao.CommandWithPizzaDao
import com.example.dimare.data.entities.Command
import com.example.dimare.data.helpers.Converters

@Database(
    entities = [Command::class],
    exportSchema = false,
    version = 1,
)
@TypeConverters(Converters::class)
abstract class DimareDatabase : RoomDatabase() {
    abstract fun commandDao(): CommandDao

    companion object {
        @Volatile
        private var INSTANCE: DimareDatabase? = null

        fun getDatabase(context: Context): DimareDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DimareDatabase::class.java,
                    "dimare_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
