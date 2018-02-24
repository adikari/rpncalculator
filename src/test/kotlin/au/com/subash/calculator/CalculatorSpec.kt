package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

class CalculatorSpec : Spek ({

    given ("a calculator") {

        on ("calculate") {

            // it("")

        }

        on("get result") {

            it ("should return result of previous operation") {
                val calculator = Calculator()

                calculator.calculate("1 2 +")
                calculator.getResult() `should equal` 3.0

                calculator.calculate("2 +")
                calculator.getResult() `should equal` 5.0

                calculator.calculate("5 5 * +")
                calculator.getResult() `should equal` 30.0
            }

            it ("should throw exception if no calculation was performed") {
                try {
                    val calculator = Calculator()
                    calculator.getResult()

                    fail("Should throw InvalidOperationException.")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "No calculation has been performed!!"
                }
            }
        }
    }
})