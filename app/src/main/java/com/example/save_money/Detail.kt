package com.example.save_money

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.save_money.Constants.DETAIL_TABLE

@Entity(tableName = DETAIL_TABLE)
data class Detail(
    @PrimaryKey
    val amount: Int,
    val content: String,
    val date: String
)
