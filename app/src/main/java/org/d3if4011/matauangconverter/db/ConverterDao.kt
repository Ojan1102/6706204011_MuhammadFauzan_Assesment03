package org.d3if4011.matauangconverter.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConverterDao {
    @Insert
    fun insert(converter: ConverterEntity)

    @Query("SELECT * FROM converter ORDER BY id DESC")
    fun getLastConverter(): LiveData<List<ConverterEntity>>

    @Query("DELETE FROM converter")
    fun clearData()
}