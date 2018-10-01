package com.cts.financialskill.handlers.basic

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import mu.KLogging
import java.util.*

class FallbackIntentHandler : KLogging(), RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean =
            input.matches(intentName("AMAZON.FallbackIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        logger.info { "[Alexa] - Log happening, $input" }
        val speechText = "Sorry, I don't know that. You can try saying help! Or Ask Sinuhe for a new feature"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Unknown", speechText)
                .withReprompt(speechText)
                .build()
    }
}