package com.ibrajix.prime.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CasesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCases(case: List<Case>)

    @Transaction
    @Query("SELECT * FROM cases_table ORDER BY id DESC")
    fun getAllCases(): Flow<List<Case>>

}