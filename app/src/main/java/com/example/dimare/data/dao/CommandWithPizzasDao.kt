package com.example.dimare.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.dimare.data.entity.CommandWithPizzas

@Dao
interface CommandWithPizzasDao {
    @Transaction
    @Query("SELECT * FROM commands")
    fun findAll(): LiveData<List<CommandWithPizzas>>
}
