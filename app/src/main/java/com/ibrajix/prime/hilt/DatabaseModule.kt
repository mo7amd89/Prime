package com.ibrajix.prime.hilt

import android.content.Context
import androidx.room.Room
import com.ibrajix.prime.room.MyDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesMyDatabase(@ApplicationContext context: Context) : MyDatabase {
        return Room.databaseBuilder(context, MyDatabase::class.java, "cases_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesCasesDao(database: MyDatabase) = database.casesDao()

}