package com.cts.financialskill.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Assets(val asset1: String, val asset2: String)