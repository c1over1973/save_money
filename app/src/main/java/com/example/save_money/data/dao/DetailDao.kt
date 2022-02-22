package com.example.save_money.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.save_money.model.Detail

@Dao
interface DetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDetail(detail: Detail)

    @Query("SELECT * FROM detail_table ORDER BY id DESC")
    fun readAllDetail(): LiveData<List<Detail>>

    @Query("DELETE FROM detail_table")
    suspend fun deleteAllDetails()

    @Query("UPDATE detail_table SET amount =:amount, content =:content WHERE id =:id")
    suspend fun updateDetail(id: Int, amount: Int, content: String)

    @Query("DELETE FROM detail_table WHERE id =:id")
    suspend fun deleteDetail(id: Int)
}