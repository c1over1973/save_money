package com.example.save_money.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.save_money.data.Constants.DETAIL_TABLE

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetail(detail: Detail)

    @Delete
    suspend fun deleteDetail(detail: Detail)

    @Update
    suspend fun updateDetail(detail: Detail)

    @Query("SELECT * FROM detail_table ORDER BY id DESC")
    fun readAllDetail(): LiveData<List<Detail>>

    @Query("DELETE FROM detail_table")
    suspend fun deleteAllDetails()
}