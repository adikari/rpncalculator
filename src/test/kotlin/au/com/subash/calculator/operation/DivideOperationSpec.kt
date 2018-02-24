package au.com.subash.calculator.operation

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object DivideOperationSpec : Spek({
    given ("divide operation") {

        on("operate") {
            val operation = OperationFactory.get("/")

            it("should return result of dividing second operand by first operand") {
                operation.operate(2.0, 4.0) `should equal` 2.0
                operation.operate(-1.0, 2.0) `should equal` -2.0
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }

            it("should throw exception if first operand is 0.0") {
                try {
                    operation.operate(0.0, 2.0)
                    fail("2.0 / 0.0 should throw InvalidOperationException")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Cannot divide operand by 0!!"
                }
            }
        }
    }
})