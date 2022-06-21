package org.d3if4011.matauangconverter.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if4011.matauangconverter.model.MataUang
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/Ojan1102/Assesment2/master/"
private const val BASE_URL_IMG = "https://raw.githubusercontent.com/Ojan1102/Assesment2/master/img/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MataUangConverterService {
    @GET("mata-uang.json")
    suspend fun getResult(): List<MataUang>
}

object MataUangConverter {
    val service: MataUangConverterService by lazy {
        retrofit.create(MataUangConverterService::class.java)
    }
    fun getMataUangUrl(negara: String): String {
        return "$BASE_URL_IMG$negara.png"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }