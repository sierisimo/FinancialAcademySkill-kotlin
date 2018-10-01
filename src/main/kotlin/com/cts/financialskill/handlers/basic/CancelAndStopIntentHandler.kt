package com.cts.financialskill.handlers.basic

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import mu.KLogging
import java.util.*

class CancelAndStopIntentHandler : KLogging(),RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean =
            input.matches(intentName("AMAZON.StopIntent")
                    .or(intentName("AMAZON.CancelIntent")))

    override fun handle(input: HandlerInput): Optional<Response> {
        logger.info { "[Alexa] - Log happening, $input" }
        val speechText = "Goodbye"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Goodbye", speechText)
                .build()
    }
}