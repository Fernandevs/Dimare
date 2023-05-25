package com.example.dimare.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

import com.example.dimare.data.dao.CommandDao
import com.example.dimare.data.dao.CommandWithPizzasDao
// import com.example.dimare.data.dao.CommandWithPizzaDao
import com.example.dimare.data.dao.PizzaDao
import com.example.dimare.data.entity.Command
import com.example.dimare.data.entity.Pizza

@Database(
    entities = [Command::class, Pizza::class],
    exportSchema = false,
    version = 1,
)
abstract class DimareDatabase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
    abstract fun commandDao(): CommandDao
    abstract fun commandWithPizzasDao(): CommandWithPizzasDao

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
