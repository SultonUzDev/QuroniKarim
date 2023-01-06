package com.sultonuzdev.qurontafsirbymuhammadsodiq.di

import android.content.Context
import androidx.room.Room
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api.SurahDetailsApi
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.SurahDatabase
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository.SurahDetailsRepositoryImpl
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository.SurahRepositoryImpl
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    //
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        addInterceptor(httpLoggingInterceptor)
    }.build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_SURAH_INFO_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideSurahInfoApi(retrofit: Retrofit): SurahDetailsApi =
        retrofit.create(SurahDetailsApi::class.java)

    @Provides
    @Singleton
    fun provideSurahDetailsRepository(
        api: SurahDetailsApi,
        database: SurahDatabase
    ): SurahDetailsRepository =
        SurahDetailsRepositoryImpl(api, database.surahDao)


}