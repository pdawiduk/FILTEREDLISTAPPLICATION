package com.example.roomapplicationwithrecyclerview.database

import androidx.room.*
import java.util.*

@Dao
interface RecordDAO{

    @Query("SELECT * FROM records")
    fun getAll():List<RecordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( records:List<RecordEntity>)

    @Query(" SELECT * FROM Records WHERE name LIKE :value")
    fun filterRecordsByName( value:String):List<RecordEntity>

    @Query(" SELECT * FROM Records WHERE user LIKE :value")
    fun filterRecordByUser( value:String):List<RecordEntity>

    @Query(" SELECT * FROM Records WHERE local LIKE :value")
    fun filterRecordByLocal( value:String):List<RecordEntity>

    @Query(" SELECT * FROM Records WHERE hour LIKE :value")
    fun filterRecordByHour( value:String):List<RecordEntity>

    @Query(" SELECT * FROM Records WHERE date LIKE :value")
    fun filterRecordByDate( value:String):List<RecordEntity>

    @Query("DELETE FROM RECORDS")
    fun deleteAll()

}