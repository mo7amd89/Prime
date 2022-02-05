package com.ibrajix.prime.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cases_table")
data class Case(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "clientsName")
    val clientName: String,
    @ColumnInfo(name = "genId")
    val genId: String
)