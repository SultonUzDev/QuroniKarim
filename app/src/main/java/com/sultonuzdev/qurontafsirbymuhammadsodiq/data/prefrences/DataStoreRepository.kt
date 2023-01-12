package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.prefrences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "introduction")

class DataStoreRepository(context: Context) {

    private object PreferenceKey {
        val onIntroductionKey = booleanPreferencesKey(name = "isIntroduced")
    }

    private val dataStore = context.dataStore


    suspend fun saveStateOfIntroduction(introduced: Boolean) {
        dataStore.edit {
            it[PreferenceKey.onIntroductionKey] = introduced
        }
    }


    suspend fun readStateOfIntroduction(): Flow<Boolean> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw  exception
            }

        }.map {
            val introduced = it[PreferenceKey.onIntroductionKey] ?: false
            introduced
        }

    }

}
