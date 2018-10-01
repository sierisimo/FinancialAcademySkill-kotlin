package com.cts.financialskill.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.Slot
import com.amazon.ask.request.Predicates
import com.cts.financialskill.data.Assets
import com.cts.financialskill.data.CompanyValue
import com.cts.financialskill.data.companies
import com.cts.financialskill.firebase.FirebaseClient
import mu.KLogging
import java.util.*

class CompanyCompareIntentHandler : KLogging(), RequestHandler {
    private val companyNotFound = "not Found"
    private var passedValue = ""

    override fun canHandle(input: HandlerInput) = input.matches(Predicates.intentName("CompanyCompareIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        val request = input.requestEnvelope.request as IntentRequest
        val intent = request.intent
        val slots: Map<String, Slot> = intent.slots

        val companyDest = slots["company_dest"]
        val companyBase = slots["company_base"]

        val company1 = getCompanyName(companyBase)
        val company2 = getCompanyName(companyDest)
        val speechText = buildString {
            if (company1.name == companyNotFound || company2.name == companyNotFound) {
                append("There is missing information on the comparative companies. Please try again with valid names")
            } else {
                val assets = Assets(company1.id, company2.id)
                FirebaseClient.updateBoth(assets)
                append("Comparative between companies will be visible on screen soon")
            }
        }

        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("CompanyComparativeInfo", speechText)
                .build()
    }

    private fun getCompanyName(slot: Slot?): CompanyValue {
        if (slot == null) return CompanyValue(companyNotFound, "")

        var companyName = companyNotFound
        var companyId = ""
        with(slot) {
            if (value != null) {
                passedValue = value
            }

            val resPerAuth = resolutions.resolutionsPerAuthority
            resPerAuth.forEach { resolution ->
                resolution.values?.forEach { wrapper ->
                    val tmp = companies.find { it.name == wrapper.value.name }
                    companyName = tmp?.name ?: companyNotFound
                    companyId = tmp?.id ?: ""
                }
            }
        }

        return CompanyValue(companyName, companyId)
    }

    fun Any.inLog(msg: String = "") = logger.error { "[Alexa] - $msg :: $this" }
}