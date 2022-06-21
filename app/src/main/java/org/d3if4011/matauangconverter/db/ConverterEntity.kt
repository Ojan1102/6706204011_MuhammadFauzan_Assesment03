package org.d3if4011.matauangconverter.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "converter")
data class ConverterEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var jumlahUang: Float,
    var hasil: Float
    )