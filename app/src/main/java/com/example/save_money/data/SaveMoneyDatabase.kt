package com.example.save_money.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.save_money.data.dao.DetailDao
import com.example.save_money.data.dao.GoalsDao
import com.example.save_money.model.Detail
import com.example.save_money.model.Goals

@Database(entities = [Detail::class, Goals::class], version = 1, exportSchema = false)
abstract class SaveMoneyDatabase: RoomDatabase(){

    abstract fun detailDao(): DetailDao
    abstract fun goalsDao(): GoalsDao

}