package com.example.save_money

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface GoalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGoals(goals: Goals)

    @Delete
    suspend fun deleteGoals(goals: Goals)

}