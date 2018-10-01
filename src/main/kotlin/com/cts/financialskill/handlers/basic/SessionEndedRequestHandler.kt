package com.cts.financialskill.handlers.basic

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.RequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import com.amazon.ask.request.Predicates.requestType
import mu.KLogging
import java.util.*

class SessionEndedRequestHandler : KLogging(), RequestHandler {
    override fun canHandle(input: HandlerInput): Boolean {
        return input.matches(requestType(SessionEndedRequest::class.java))
    }

    override fun handle(input: HandlerInput): Optional<Response> {
        logger.info { "[Alexa] - Log happening, $input" }
        // any cleanup logic goes here
        return input.responseBuilder.build()
    }


}