package com.example.dimare.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.dimare.data.entity.Command

@Dao
interface CommandDao {
    @Query("SELECT * FROM commands")
    fun findAll(): LiveData<List<Command>>

    @Query("SELECT * FROM commands WHERE commandId = :uid")
    fun findOne(uid: Int): LiveData<Command?>

    @Insert
    suspend fun insert(pizza: Command)

    @Update
    suspend fun update(pizza: Command)

    @Delete
    suspend fun remove(pizza: Command)
}
