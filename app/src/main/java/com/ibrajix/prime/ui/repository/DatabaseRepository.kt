package com.ibrajix.prime.ui.repository

import com.ibrajix.prime.room.Case
import com.ibrajix.prime.room.CasesDao
import com.ibrajix.prime.ui.model.itemList
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val casesDao: CasesDao) {

    private val casesList = itemList()

    suspend fun insertCases() = casesDao.insertCases(casesList)

    val getAllCases : Flow<List<Case>> get() = casesDao.getAllCases()


}