package com.example.dimare.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.dimare.data.entities.Command

@Dao
interface CommandDao {
    @Query("SELECT * FROM commands")
    fun findAll(): LiveData<List<Command>>

    @Query("SELECT * FROM commands WHERE commandId = :uid")
    fun findOne(uid: Int): LiveData<Command?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(command: Command)

    @Update
    suspend fun update(command: Command)

    @Delete
    suspend fun remove(command: Command)
}
