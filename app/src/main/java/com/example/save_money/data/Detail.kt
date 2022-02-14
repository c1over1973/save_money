package com.example.save_money.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.save_money.data.Constants.DETAIL_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = DETAIL_TABLE)
data class Detail(
    @PrimaryKey
    val amount: Int,
    val content: String,
    val date: String
)
