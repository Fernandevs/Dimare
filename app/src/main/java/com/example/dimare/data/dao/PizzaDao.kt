package com.example.dimare.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

import com.example.dimare.data.entity.Pizza

@Dao
interface PizzaDao {
    @Query("SELECT * FROM pizzas")
    fun findAll(): LiveData<List<Pizza>>

    @Query("SELECT * FROM pizzas WHERE pizzaId = :uid")
    fun findOne(uid: Int): LiveData<Pizza?>

    @Insert
    suspend fun insert(pizza: Pizza)

    @Update
    suspend fun update(pizza: Pizza)

    @Delete
    suspend fun remove(pizza: Pizza)
}
