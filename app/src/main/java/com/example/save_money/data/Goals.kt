package com.example.save_money.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.save_money.data.Constants.GOALS_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = GOALS_TABLE)
data class Goals(
    @PrimaryKey(autoGenerate = false)
    val goal: String,
    val amount: Int,
    val sum: Int
)
