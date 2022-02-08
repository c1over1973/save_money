package com.example.save_money

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.save_money.Constants.SAVE_MONEY_DATABASE

@Database(entities = [Detail::class, Goals::class], version = 1)
abstract class SaveMoneyDatabase: RoomDatabase(){

    abstract fun detailDao(): DetailDao
    abstract fun goalsDao(): GoalsDao

    companion object{
        @Volatile
        private var INSTANCE: SaveMoneyDatabase? = null

        fun getDatabase(context: Context): SaveMoneyDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SaveMoneyDatabase::class.java,
                    SAVE_MONEY_DATABASE
                ).build()
                INSTANCE = instance
                return instance
            }
        }


    }
}