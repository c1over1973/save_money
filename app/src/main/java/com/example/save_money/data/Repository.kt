package com.example.save_money.data

import androidx.lifecycle.LiveData
import com.example.save_money.data.Detail
import com.example.save_money.data.DetailDao
import com.example.save_money.data.GoalsDao
import javax.inject.Inject

class Repository @Inject constructor(
    private val saveMoneyDatabase: SaveMoneyDatabase
) {
    private val detailDao = saveMoneyDatabase.detailDao()
    private val goalsDao = saveMoneyDatabase.goalsDao()
    val readAllDetail: LiveData<List<Detail>> = detailDao.readAllDetail()
    val readAllGoals: LiveData<List<Goals>> = goalsDao.readAllGoals()


    suspend fun addDetail(detail: Detail) {
        detailDao.addDetail(detail)
    }

    suspend fun addGoals(goals: Goals) {
        goalsDao.addGoals(goals)
    }

    suspend fun deleteAllGoals() {
        goalsDao.deleteAllGoals()
    }

    suspend fun deleteAllDetails(){
        detailDao.deleteAllDetails()
    }

    suspend fun updateSum(goal: String, sum: Int) {
        goalsDao.updateSum(goal, sum)
    }


}