package com.cts.financialskill.handlers.basic

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import mu.KLogging
import java.util.*

class HelpIntentHandler : KLogging(), RequestHandler {
    override fun canHandle(input: HandlerInput) = input.matches(intentName("AMAZON.HelpIntent"))

    override fun handle(input: HandlerInput): Optional<Response> {
        logger.info { "[Alexa] - Log happening, $input" }
        val speechText = "You can say hello to me!"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("HelloWorld", speechText)
                .withReprompt(speechText)
                .build()
    }
}