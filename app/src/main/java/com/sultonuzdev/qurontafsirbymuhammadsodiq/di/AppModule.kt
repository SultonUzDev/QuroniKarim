package com.sultonuzdev.qurontafsirbymuhammadsodiq.di

import android.content.Context
import androidx.room.Room
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.SurahDatabase
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository.SurahRepositoryImpl
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideSurahDatabase(@ApplicationContext context: Context): SurahDatabase =
        Room.databaseBuilder(context, SurahDatabase::class.java, "quran.db")
            .createFromAsset("quran.db")
            .allowMainThreadQueries()
            .build()


    @Provides
    @Singleton
    fun provideRepository(database: SurahDatabase): SurahRepository =
        SurahRepositoryImpl(database.surahDao)





}