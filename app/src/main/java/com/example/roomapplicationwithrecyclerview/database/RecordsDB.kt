package com.example.roomapplicationwithrecyclerview.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RecordEntity::class), version = 1)
abstract class RecordsDB :RoomDatabase(){
    abstract fun recordDao():RecordDAO
}