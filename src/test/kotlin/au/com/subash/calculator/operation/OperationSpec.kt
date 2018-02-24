package au.com.subash.calculator.operation

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object OperationSpec : Spek({

    given("an operation") {

        on("addition") {
            val operation = OperationFactory.get("+")

            it("should return result of adding left operand to right operand") {
                operation.operate(2.0, 3.0) `should equal` 5.0
                operation.operate(2.5, 3.5) `should equal` 6.0
                operation.operate(2.5, 4.0) `should equal` 6.5
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

        on("subtraction") {
            val operation = OperationFactory.get("-")

            it("should return result of subtracting first operand from second operand") {
                operation.operate(1.0, 2.0) `should equal` 1.0
                operation.operate(2.11111111111, 4.0) `should equal` 1.88888888889
                operation.operate(2.11111111111, 4.1233393) `should equal` 2.0122281888899995
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

        on("multiplication") {
            val operation = OperationFactory.get("*")

            it("should return result of multiplying first operand with second operand") {
                operation.operate(2.0, 3.0) `should equal` 6.0
                operation.operate(2.12344, 3.123345) `should equal` 6.6322357068
                operation.operate(3.1233, 23.1233) `should equal` 72.22100289
            }

            it("should have 2 required operand") {
                operation.requiredOperand `should equal` 2
            }
        }

        on("division") {
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

        on("square root") {
            val operation = OperationFactory.get("sqrt")

            it("should return result of square root of operand") {
                operation.operate(2.0, 0.0) `should equal` 1.4142135623730951
                operation.operate(4.0, 0.0) `should equal` 2.0
            }

            it("should have 1 required operand") {
                operation.requiredOperand `should equal` 1
            }

            it("should return result ignoring second operand") {
                operation.operate(4.0, 3.0) `should equal` 2.0
                operation.operate(4.0, 4.0) `should equal` 2.0
            }
        }
    }
})


