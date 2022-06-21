package org.d3if4011.matauangconverter.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4011.matauangconverter.db.ConverterDao

class HistoriViewModel(private val db: ConverterDao) : ViewModel() {
    val data = db.getLastConverter()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}