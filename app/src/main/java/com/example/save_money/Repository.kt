package com.example.save_money

import androidx.lifecycle.LiveData

class Repository(private val goalsDao: GoalsDao, private val detailDao: DetailDao) {
    val readAllDetail: LiveData<List<Detail>> = detailDao.readAllDetail()

    suspend fun addDetail(detail: Detail){
        detailDao.addDetail(detail)
    }

    suspend fun deleteDetail(detail: Detail){
        detailDao.deleteDetail(detail)
    }

    suspend fun updateDetail(detail: Detail){
        detailDao.updateDetail(detail)
    }
}