package au.com.subash.calculator

import au.com.subash.calculator.exception.InvalidOperationException
import junit.framework.TestCase.fail
import org.amshove.kluent.`should equal`
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object OperationSpec : Spek({

    given("an operation") {

        on("get operator") {
            it ("should return add operator") {
                Operation.getOperator("+") `should equal` Operation.ADD
            }

            it ("should return subtract operator") {
                Operation.getOperator("-") `should equal` Operation.SUBTRACT
            }

            it ("should return division operator") {
                Operation.getOperator("/") `should equal` Operation.DIVIDE
            }

            it ("should return multiply operator") {
                Operation.getOperator("*") `should equal` Operation.MULTIPLY
            }

            it ("should return square root operator") {
                Operation.getOperator("sqrt") `should equal` Operation.SQUARE_ROOT
            }

            it ("should return undo operator") {
                Operation.getOperator("undo") `should equal` Operation.UNDO
            }

            it ("should return clear operator") {
                Operation.getOperator("clear") `should equal` Operation.CLEAR
            }

            it("should throw InvalidOperationException") {
                try {
                    Operation.getOperator(")")
                    fail("Should throw InvalidOperationException")
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Invalid operator!!"
                }
            }
        }

        on("addition") {
            val operation = Operation.getOperator("+")

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
            val operation = Operation.getOperator("-")

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
            val operation = Operation.getOperator("*")

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
            val operation = Operation.getOperator("/")

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
            val operation = Operation.getOperator("sqrt")

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

        on("undo") {
            val operation = Operation.getOperator("undo")

            it("should throw InvalidOperationException") {
                try {
                    operation.operate(0.0, 0.0)
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Undo operation cannot be performed directly"
                }
            }

            it("should have 0 required operand") {
                operation.requiredOperand `should equal` 0
            }
        }

        on("clear") {
            val operation = Operation.getOperator("clear")

            it("should throw InvalidOperationException") {
                try {
                    operation.operate(0.0, 0.0)
                } catch (e : InvalidOperationException) {
                    e.message `should equal` "Clear operation cannot be performed directly"
                }
            }

            it("should have 0 required operand") {
                operation.requiredOperand `should equal` 0
            }
        }
    }
})


