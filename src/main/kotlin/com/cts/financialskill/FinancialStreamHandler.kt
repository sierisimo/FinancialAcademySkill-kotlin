package com.cts.financialskill

import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills

class FinancialStreamHandler : SkillStreamHandler(
        Skills.standard()
                .addRequestHandlers(
                        WelcomeIntentHandler(),
                        CancelAndStopIntentHandler(),
                        FallbackIntentHandler()
                )
                .build()
)