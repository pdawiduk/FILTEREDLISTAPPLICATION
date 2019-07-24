package com.example.roomapplicationwithrecyclerview.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Records")
data class RecordEntity(
    @PrimaryKey(autoGenerate = true)
    val uid:Int,
    val name:String,
    val date: String,
    val hour: String,
    val user: String,
    val local: String
)