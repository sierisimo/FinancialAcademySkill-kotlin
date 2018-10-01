package com.cts.financialskill.handlers.basic

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.LaunchRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.requestType
import mu.KLogging
import java.util.*

class LaunchRequestHandler : KLogging(), RequestHandler {
    override fun canHandle(input: HandlerInput) = input.matches(requestType(LaunchRequest::class.java))


    override fun handle(input: HandlerInput): Optional<Response> {
        logger.info { "[Alexa] - Log happening, $input" }
        val speechText = "Welcome to the Financial Academy, try asking for a company information"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("HelloFinancialAcademy", speechText)
                .withReprompt(speechText)
                .build()
    }
}