package com.cts.financialskill.data

data class CompanyValue(val name: String, val id: String)

val companies = setOf(
        CompanyValue("Ethereum", "eth"),
        CompanyValue("Bitcoin", "btc"),
        CompanyValue("Facebook", "FB"),
        CompanyValue("Amazon", "AMZN"),
        CompanyValue("Google", "GOOG")
)