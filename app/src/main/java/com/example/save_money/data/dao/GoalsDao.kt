package com.example.save_money.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.save_money.model.Goals

@Dao
interface GoalsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addGoals(goals: Goals)

    @Query("SELECT * FROM goals_table LIMIT 1")
    fun readAllGoals(): LiveData<List<Goals>>

    @Query("DELETE FROM goals_table")
    suspend fun deleteAllGoals()

    @Query("UPDATE goals_table SET sum =:sum WHERE goal =:goal")
    suspend fun updateSum(goal: String, sum: Int)
}