package org.d3if4011.matauangconverter.ui.hitung

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4011.matauangconverter.db.ConverterDao
import org.d3if4011.matauangconverter.db.ConverterDb
import org.d3if4011.matauangconverter.db.ConverterEntity
import org.d3if4011.matauangconverter.model.HasilConverter
import org.d3if4011.matauangconverter.model.hitungConverter

class HitungViewModel(private val db: ConverterDao) : ViewModel() {
    private val hasilConverter = MutableLiveData<HasilConverter?>()


    fun hitungConverter (jumlahUang: Float, mataUang: String) {
        var num = 0
        when(mataUang) {
            "usd" -> {
                num = 14300
            }
            "yen" -> {
                num = 117
            }
            "euro" -> {
                num = 15900
            }
        }
        val dataConverter = ConverterEntity(
            jumlahUang = jumlahUang,
            hasil =  jumlahUang / num
        )
        hasilConverter.value = dataConverter.hitungConverter()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataConverter)
            }
        }
    }
    fun getHasilConveter(): LiveData<HasilConverter?> = hasilConverter
}