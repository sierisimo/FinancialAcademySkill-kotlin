package com.cts.financialskill

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.request.Predicates.intentName
import java.util.*
import jdk.nashorn.tools.ShellFunctions.input



class CancelAndStopIntentHandler : RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean =
            input.matches(intentName("AMAZON.StopIntent")
                    .or(intentName("AMAZON.CancelIntent")))


    override fun handle(input: HandlerInput): Optional<Response> {
        val speechText = "Goodbye"
        return input.responseBuilder
                .withSpeech(speechText)
                .withSimpleCard("Goodbye", speechText)
                .build()
    }
}