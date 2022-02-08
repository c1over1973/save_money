package com.example.save_money

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.save_money.Constants.DETAIL_TABLE

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetail(detail: Detail)

    @Delete
    suspend fun deleteDetail(detail: Detail)

    @Update
    suspend fun updateDetail(detail: Detail)

    @Query("SELECT * FROM $DETAIL_TABLE")
    fun readAllDetail(): LiveData<List<Detail>>
}