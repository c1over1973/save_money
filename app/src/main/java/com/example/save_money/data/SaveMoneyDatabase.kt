package com.example.save_money.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.save_money.data.Constants.SAVE_MONEY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Database(entities = [Detail::class, Goals::class], version = 1, exportSchema = false)
abstract class SaveMoneyDatabase: RoomDatabase(){

    abstract fun detailDao(): DetailDao
    abstract fun goalsDao(): GoalsDao

//    @Module
//    @InstallIn(SingletonComponent::class)
//    companion object{
//        private var INSTANCE: SaveMoneyDatabase? = null
//
//        @Provides
//        @Singleton
//        fun getDatabase(context: Context): SaveMoneyDatabase {
//            val tempInstance = INSTANCE
//            if(tempInstance != null){
//                return tempInstance
//            }
//
//            synchronized(this){
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    SaveMoneyDatabase::class.java,
//                    SAVE_MONEY_DATABASE
//                ).build()
//                INSTANCE = instance
//                return instance
//            }
//            return Room.databaseBuilder(
//                context.applicationContext,
//                SaveMoneyDatabase::class.java,
//                SAVE_MONEY_DATABASE
//            ).build()
//        }
//
//
//    }
}