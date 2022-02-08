package com.example.save_money

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.save_money.Constants.GOALS_TABLE

@Entity(tableName = GOALS_TABLE)
data class Goals(
    @PrimaryKey(autoGenerate = false)
    val id: Int
)
