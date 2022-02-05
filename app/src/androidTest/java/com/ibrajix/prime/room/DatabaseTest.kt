package com.ibrajix.prime.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@OptIn(ExperimentalCoroutinesApi::class)
@SmallTest
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var myDatabase: MyDatabase
    private lateinit var casesDao: CasesDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        myDatabase = Room.inMemoryDatabaseBuilder(context, MyDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        casesDao = myDatabase.casesDao()
    }


    @After
    fun closeDb(){
        myDatabase.close()
    }



    @Test
    fun insertAlarmAndCheckIfInserted() = runTest {

        val cases = listOf(
            Case(
                id = 1,
                date = "Delivered on 20-10-2019",
                firstClientName = "Mailantark",
                secondClientName = "Tongo",
                genId = "(2019) LPELR - 42466 (SC)"
            )
        )
       casesDao.insertCases(cases)
        val getAllAlarms = casesDao.getAllCases().first()
        assertThat(getAllAlarms).containsAnyIn(cases)
    }
}