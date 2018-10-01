package com.cts.financialskill.firebase

import com.cts.financialskill.data.Assets
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.PUT

interface FirebaseService {
    @PUT("asset1.json")
    fun updateAsset1(@Body value: String): Call<String>

    @PUT("asset2.json")
    fun updateAsset2(@Body value: String): Call<String>

    @PUT(".json")
    fun updateBoth(@Body assets: Assets): Call<Assets>
}