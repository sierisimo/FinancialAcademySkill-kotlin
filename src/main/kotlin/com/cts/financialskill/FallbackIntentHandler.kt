package com.cts.financialskill

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*

class FallbackIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean =
            input.matches(intentName("AMAZON.FallbackIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Sorry, I don't know that. You can say try saying help! Or Ask Sinuhe for a new feature"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Unknown", speechText)
                .withReprompt(speechText)
                .build()
    }
}