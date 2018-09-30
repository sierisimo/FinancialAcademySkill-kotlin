package com.cts.financialskill

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class WelcomeIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean = input.matches(intentName("WelcomeIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Welcome to Financial Help"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Welcome", speechText)
                .build()
    }
}