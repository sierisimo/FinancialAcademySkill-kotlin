package com.cts.financialskill.firebase

import com.cts.financialskill.data.Assets
import mu.KLogging
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object FirebaseClient : KLogging() {
    private val okHttpBuilder = OkHttpClient.Builder()

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://ihgdemo-5d613.firebaseio.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()

    private val service = retrofit.create(FirebaseService::class.java)

    fun updateAsset1(value: String) {
        execute(service.updateAsset1(value))
    }

    fun updateAsset2(value: String) {
        execute(service.updateAsset2(value))
    }

    fun updateBoth(assets: Assets){
        with(service.updateBoth(assets).execute()){
            logger.error { "[Alexa] - $isSuccessful" }
            logger.error { "[Alexa] - ${body()}" }
            logger.error { "[Alexa] - ${code()}" }
            logger.error { "[Alexa] - ${errorBody()}" }
            logger.error { "[Alexa] - ${message()}" }
        }
    }

    private fun execute(call: Call<String>) {
        with(call.execute()) {
            logger.error { "[Alexa] - $isSuccessful" }
            logger.error { "[Alexa] - ${body()}" }
            logger.error { "[Alexa] - ${code()}" }
            logger.error { "[Alexa] - ${errorBody()}" }
            logger.error { "[Alexa] - ${message()}" }
        }
    }
}