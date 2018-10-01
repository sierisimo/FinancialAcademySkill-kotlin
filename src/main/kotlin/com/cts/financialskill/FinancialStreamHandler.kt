package com.cts.financialskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import com.cts.financialskill.handlers.CompanyCompareIntentHandler
import com.cts.financialskill.handlers.CompanyIntentHandler
import com.cts.financialskill.handlers.WelcomeIntentHandler
import com.cts.financialskill.handlers.basic.*
import mu.KLogging

class FinancialStreamHandler : SkillStreamHandler(
        Skills.standard()
                .addRequestHandlers(
                        LaunchRequestHandler(),
                        WelcomeIntentHandler(),
                        CompanyIntentHandler(),
                        CompanyCompareIntentHandler(),
                        CancelAndStopIntentHandler(),
                        FallbackIntentHandler(),
                        HelpIntentHandler(),
                        SessionEndedRequestHandler()
                )
                .build()
) {
    companion object : KLogging()

    init {
        logger.info { "[Alexa] - Running…" }
    }
}