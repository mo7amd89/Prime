package com.ibrajix.prime.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Case::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun casesDao():CasesDao
}