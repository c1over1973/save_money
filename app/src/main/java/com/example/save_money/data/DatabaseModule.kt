package com.example.save_money.data

import android.content.Context
import androidx.room.Room
import com.example.save_money.data.Constants.SAVE_MONEY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): SaveMoneyDatabase{
        return Room.databaseBuilder(
            context,
            SaveMoneyDatabase::class.java,
            SAVE_MONEY_DATABASE
        ).build()
    }
}