package org.d3if4011.matauangconverter.model

import org.d3if4011.matauangconverter.db.ConverterEntity

fun ConverterEntity.hitungConverter():HasilConverter{
    val usd = jumlahUang / 14300
    val yen = jumlahUang / 117
    val euro = jumlahUang / 15900


    return HasilConverter(usd, yen, euro)
}