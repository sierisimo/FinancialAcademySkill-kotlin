package com.cts.financialskill.firebase

import com.cts.financialskill.data.Assets
import org.junit.jupiter.api.Test

internal class FirebaseClientTest {

    @Test
    fun `test asset 1 is actually updated`() {
        FirebaseClient.updateAsset1("AAA")
        Thread.sleep(8000)
    }

    @Test
    fun `test asset 2 is actually updated`() {
        FirebaseClient.updateAsset2("AAA")
        Thread.sleep(8000)
    }

    @Test
    fun `test both elements are updated`(){
        FirebaseClient.updateBoth(Assets("DDD","AAA"))
        Thread.sleep(8000)
    }
}