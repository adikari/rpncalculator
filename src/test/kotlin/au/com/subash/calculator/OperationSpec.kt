package au.com.subash.calculator

import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object OperationSpec : Spek({

    given("a calculator") {
        on("addition") {

            it("should return correct value") {
                2 shouldEqual 2
            }
        }
    }
})


