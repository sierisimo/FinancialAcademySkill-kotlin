package com.cts.financialskill.handlers

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.model.Slot
import com.amazon.ask.request.Predicates.intentName
import com.cts.financialskill.data.CompanyValue
import com.cts.financialskill.data.companies
import com.cts.financialskill.firebase.FirebaseClient
import mu.KLogging
import java.util.*

class CompanyIntentHandler : KLogging(), RequestHandler {
    private val companyNotFound = "not Found"
    private var passedValue = ""

    override fun canHandle(input: HandlerInput) = input.matches(intentName("CompanyIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        val slots = input.getSlots()

        slots.inLog("Slots")

        val slot: Slot? = slots["asset"]
        val company = getCompanyName(slot)
        val speechText =
                if (company.name != companyNotFound) {
                    FirebaseClient.updateAsset1(company.id)
                    "Information for company ${company.name} will be showed on the screen"
                } else {
                    "The company $passedValue is not actually assigned. Try with a different one."
                }

        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("CompanyInfo", speechText)
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

    private fun Any.inLog(msg: String = "") = logger.error { "[Alexa] - $msg :: $this" }

    private fun HandlerInput.getSlots(): Map<String, Slot> {
        val request = requestEnvelope.request as IntentRequest
        val intent = request.intent
        return intent.slots
    }
}